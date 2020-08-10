package rva.ctrls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rva.jpa.Igrac;
import rva.jpa.Nacionalnost;
import rva.jpa.Tim;
import rva.repository.IgracRepository;
import rva.repository.NacionalnostRepository;
import rva.repository.TimRepository;

@RestController
public class IgracRestController {
	
	@Autowired
	private IgracRepository igracRepository;
	
	@Autowired
	private TimRepository timRepository;
	
	@Autowired
	private NacionalnostRepository nacionalnostRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("igrac")
	public Collection<Igrac> getIgraci() {
		return igracRepository.findAll();
	}
	
	@GetMapping("igrac/{id}")
	public Igrac getIgrac(@PathVariable("id") Integer id) {
		return igracRepository.getOne(id);
	}
	
	@GetMapping("igracIme/{ime}")
	public Collection<Igrac> getIgracByIme(@PathVariable("ime") String ime) {
		return igracRepository.findByImeContainingIgnoreCase(ime);
	}
	
	@GetMapping("igracPrezime/{prezime}")
	public Collection<Igrac> getIgracByPrezime(@PathVariable("prezime") String prezime) {
		return igracRepository.findByPrezimeContainingIgnoreCase(prezime);
	}
	
	@GetMapping("igraciZaTimId/{id}")
	public Collection<Igrac> igracZaTimId(@PathVariable("id") Integer id)
	{
		Tim t = timRepository.getOne(id);
		return igracRepository.findByTim(t);
	}
	
	@GetMapping("igraciZaNacionalnostSkracenica/{skracenica}")
	public Collection<Igrac> igracZaNacionalnost(@PathVariable("skracenica") String skracenica) 
	{
		Collection<Igrac> i = new ArrayList<Igrac>();
		Collection<Nacionalnost> n = nacionalnostRepository.findBySkracenicaContainingIgnoreCase(skracenica);
		for(Nacionalnost na : n)
		{
			i.addAll(igracRepository.findByNacionalnost(na));
		}
		return i;
	}
	
	@PostMapping("igrac")
	public ResponseEntity<Igrac> insertIgrac(@RequestBody Igrac igrac) {
		if(!igracRepository.existsById(igrac.getId())) {
			igracRepository.save(igrac);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("igrac")
	public ResponseEntity<Igrac> updateIgrac(@RequestBody Igrac igrac) {
		if(!igracRepository.existsById(igrac.getId())) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		igracRepository.save(igrac);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("igrac/{id}")
	public ResponseEntity<Igrac> deleteIgrac(@PathVariable("id") Integer id) {
		if(!igracRepository.existsById(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		igracRepository.deleteById(id);
		if(id == 31 && !igracRepository.existsById(31)) {
			jdbcTemplate.execute("insert into \"igrac\"(\"id\", \"ime\", \"prezime\", \"broj_reg\", \"datum_rodjenja\", \"nacionalnost\", \"tim\") values(31, 'Draymond', 'Green', 'DG-023-USA', to_date('11.05.1989.', 'dd.mm.yyyy.'), 5, 3)");
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
