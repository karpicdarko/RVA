package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rva.jpa.Tim;
import rva.repository.TimRepository;

@RestController
public class TimRestController {
	
	@Autowired
	private TimRepository timRepository;
	
	@GetMapping("tim")
	public Collection<Tim> getTimovi() {
		return timRepository.findAll();
	}
	
	@GetMapping("tim/{id}")
	public Tim getTim(@PathVariable("id") Integer id) {
		return timRepository.getOne(id);
	}
	
	@GetMapping("timNaziv/{naziv}")
	public Collection<Tim> getTimByNaziv(@PathVariable("naziv") String naziv) {
		return timRepository.findByNazivContainingIgnoreCase(naziv);
	}
}
