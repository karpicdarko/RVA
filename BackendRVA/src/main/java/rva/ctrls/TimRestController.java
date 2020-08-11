package rva.ctrls;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rva.jpa.Liga;
import rva.jpa.Tim;
import rva.repository.LigaRepository;
import rva.repository.TimRepository;

@Api(tags = {"Tim CRUD operacije"})
@RestController
public class TimRestController {
	
	@Autowired
	private TimRepository timRepository;
	
	@Autowired
	private LigaRepository ligaRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Vraca sve timove iz baze")
	@GetMapping("tim")
	public Collection<Tim> getTimovi() {
		return timRepository.findAll();
	}
	
	@ApiOperation(value = "Vraca tim ciji je id naveden")
	@GetMapping("tim/{id}")
	public Tim getTim(@PathVariable("id") Integer id) {
		return timRepository.getOne(id);
	}
	
	@ApiOperation(value = "Vraca tim ciji je naziv naveden")
	@GetMapping("timNaziv/{naziv}")
	public Collection<Tim> getTimByNaziv(@PathVariable("naziv") String naziv) {
		return timRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@ApiOperation(value = "Vraca tim koji igra u ligi cija je oznaka navedena")
	@GetMapping("timZaLiguOznaka/{oznaka}")
	public Collection<Tim> timZaLigu(@PathVariable("oznaka") String oznaka)
	{
		Collection<Tim> t = new ArrayList<Tim>();
		Collection<Liga> l = ligaRepository.findByOznakaContainingIgnoreCase(oznaka);
		for(Liga la : l)
		{
			t.addAll(timRepository.findByLiga(la));
		}
		return t;
	}
	
	@ApiOperation(value = "Upisuje tim u bazu")
	@PostMapping("tim")
	public ResponseEntity<Tim> insertTim(@RequestBody Tim tim) {
		if(!timRepository.existsById(tim.getId())) {
			timRepository.save(tim);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@ApiOperation(value = "Modifikuje tim u bazi")
	@PutMapping("tim")
	public ResponseEntity<Tim> updateTim(@RequestBody Tim tim) {
		if(!timRepository.existsById(tim.getId())) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		timRepository.save(tim);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Brise tim iz baze")
	@Transactional
	@DeleteMapping("tim/{id}")
	public ResponseEntity<Tim> deleteTim(@PathVariable("id") Integer id) {
		if(!timRepository.existsById(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		jdbcTemplate.execute("delete from igrac where tim = " + id);
		timRepository.deleteById(id);
		if(id == 16 && !timRepository.existsById(16)) {
			jdbcTemplate.execute("insert into \"tim\"(\"id\", \"naziv\", \"osnovan\", \"sediste\", \"liga\") values(16, 'Spurs', to_date('01.03.1985.', 'dd.mm.yyyy.'), 'San Antonio', 1)");
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
