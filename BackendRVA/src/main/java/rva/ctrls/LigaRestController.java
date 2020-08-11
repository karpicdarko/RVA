package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.*;
import rva.jpa.Liga;
import rva.repository.LigaRepository;

@Api(tags = {"Liga CRUD operacije"})
@RestController
public class LigaRestController {
	
	@Autowired
	private LigaRepository ligaRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Vraca sve lige iz baze")
	@GetMapping("liga")
	public Collection<Liga> getLige() {
		return ligaRepository.findAll();
	}
	
	@ApiOperation(value = "Vraca ligu ciji je id naveden")
	@GetMapping("liga/{id}")
	public Liga getLiga(@PathVariable("id") Integer id) {
		return ligaRepository.getOne(id);
	}
	
	@ApiOperation(value = "Vraca ligu ciji je naziv naveden")
	@GetMapping("ligaNaziv/{naziv}")
	public Collection<Liga> getLigaByNaziv(@PathVariable("naziv") String naziv) {
		return ligaRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@ApiOperation(value = "Vraca ligu cija je oznaka navedena")
	@GetMapping("ligaOznaka/{oznaka}")
	public Collection<Liga> getLigaByOznaka(@PathVariable("oznaka") String oznaka) {
		return ligaRepository.findByOznakaContainingIgnoreCase(oznaka);
	}
	
	@ApiOperation(value = "Upisuje ligu u bazu")
	@CrossOrigin
	@PostMapping("liga")
	public ResponseEntity<Liga> insertLiga(@RequestBody Liga liga) {
		if(!ligaRepository.existsById(liga.getId())) {
			ligaRepository.save(liga);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@ApiOperation(value = "Modifikuje ligu u bazi")
	@CrossOrigin
	@PutMapping("liga")
	public ResponseEntity<Liga> updateLiga(@RequestBody Liga liga) {
		if(!ligaRepository.existsById(liga.getId())) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		ligaRepository.save(liga);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Brise ligu iz baze")
	@CrossOrigin
	@Transactional
	@DeleteMapping("liga/{id}")
	public ResponseEntity<Liga> deleteLiga(@PathVariable("id") Integer id) {
		if(!ligaRepository.existsById(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		jdbcTemplate.execute("delete from tim where liga = " + id);
		ligaRepository.deleteById(id);
		if(id == 6 && !ligaRepository.existsById(6)) {
			jdbcTemplate.execute("insert into \"liga\"(\"id\", \"naziv\", \"oznaka\") values(6, 'Kosarkaska Liga Srbije', 'KLS')");
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
