package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rva.jpa.Nacionalnost;
import rva.repository.NacionalnostRepository;

@RestController
public class NacionalnostRestController {
	
	@Autowired
	private NacionalnostRepository nacionalnostRepository;
	
	@GetMapping("nacionalnost")
	public Collection<Nacionalnost> getNacionalnosti() {
		return nacionalnostRepository.findAll();
	}
	
	@GetMapping("nacionalnost/{id}")
	public Nacionalnost getNacionalnost(@PathVariable("id") Integer id) {
		return nacionalnostRepository.getOne(id);
	}
	
	@GetMapping("nacionalnostNaziv/{naziv}")
	public Collection<Nacionalnost> getNacionalnostByNaziv(@PathVariable("naziv") String naziv) {
		return nacionalnostRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@GetMapping("nacionalnostSkracenica/{skracenica}")
	public Collection<Nacionalnost> getNacionalnostBySkracenica(@PathVariable("skracenica") String skracenica) {
		return nacionalnostRepository.findBySkracenicaContainingIgnoreCase(skracenica);
	}
}
