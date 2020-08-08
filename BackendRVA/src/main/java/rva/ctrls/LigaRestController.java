package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rva.jpa.Liga;
import rva.repository.LigaRepository;

@RestController
public class LigaRestController {
	@Autowired
	private LigaRepository ligaRepository;
	
	@GetMapping("liga")
	public Collection<Liga> getLige() {
		return ligaRepository.findAll();
	}
	
	@GetMapping("liga/{id}")
	public Liga getLiga(@PathVariable("id") Integer id) {
		return ligaRepository.getOne(id);
	}
	
	@GetMapping("ligaNaziv/{naziv}")
	public Collection<Liga> getLigaByNaziv(@PathVariable("naziv") String naziv) {
		return ligaRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@GetMapping("ligaOznaka/{oznaka}")
	public Collection<Liga> getLigaByOznaka(@PathVariable("oznaka") String oznaka) {
		return ligaRepository.findByOznakaContainingIgnoreCase(oznaka);
	}
}
