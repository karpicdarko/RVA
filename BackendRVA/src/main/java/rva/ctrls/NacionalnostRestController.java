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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rva.jpa.Nacionalnost;
import rva.repository.NacionalnostRepository;

@Api(tags = {"Nacionalnost CRUD operacije"})
@RestController
public class NacionalnostRestController {
	
	@Autowired
	private NacionalnostRepository nacionalnostRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Vraca sve nacionalnosti iz baze")
	@GetMapping("nacionalnost")
	public Collection<Nacionalnost> getNacionalnosti() {
		return nacionalnostRepository.findAll();
	}
	
	@ApiOperation(value = "Vraca nacionalnost ciji je id naveden")
	@GetMapping("nacionalnost/{id}")
	public Nacionalnost getNacionalnost(@PathVariable("id") Integer id) {
		return nacionalnostRepository.getOne(id);
	}
	
	@ApiOperation(value = "Vraca nacionalnost ciji je naziv naveden")
	@GetMapping("nacionalnostNaziv/{naziv}")
	public Collection<Nacionalnost> getNacionalnostByNaziv(@PathVariable("naziv") String naziv) {
		return nacionalnostRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@ApiOperation(value = "Vraca nacionalnost cija je skracenica navedena")
	@GetMapping("nacionalnostSkracenica/{skracenica}")
	public Collection<Nacionalnost> getNacionalnostBySkracenica(@PathVariable("skracenica") String skracenica) {
		return nacionalnostRepository.findBySkracenicaContainingIgnoreCase(skracenica);
	}
	
	@ApiOperation(value = "Upisuje nacionalnost u bazu")
	@CrossOrigin
	@PostMapping("nacionalnost")
	public ResponseEntity<Nacionalnost> insertNacionalnost(@RequestBody Nacionalnost nacionalnost) {
		if(!nacionalnostRepository.existsById(nacionalnost.getId())) {
			nacionalnostRepository.save(nacionalnost);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@ApiOperation(value = "Modifikuje nacionalnost u bazi")
	@CrossOrigin
	@PutMapping("nacionalnost")
	public ResponseEntity<Nacionalnost> updateNacionalnost(@RequestBody Nacionalnost nacionalnost) {
		if(!nacionalnostRepository.existsById(nacionalnost.getId())) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		nacionalnostRepository.save(nacionalnost);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Brise nacionalnost iz baze")
	@CrossOrigin
	@Transactional
	@DeleteMapping("nacionalnost/{id}")
	public ResponseEntity<Nacionalnost> deleteNacionalnost(@PathVariable("id") Integer id) {
		if(!nacionalnostRepository.existsById(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		jdbcTemplate.execute("delete from igrac where nacionalnost = " + id);
		nacionalnostRepository.deleteById(id);
		if(id == 6 && !nacionalnostRepository.existsById(6)) {
			jdbcTemplate.execute("insert into \"nacionalnost\"(\"id\", \"naziv\", \"skracenica\") values(6, 'Argentinac', 'ARG')");
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
