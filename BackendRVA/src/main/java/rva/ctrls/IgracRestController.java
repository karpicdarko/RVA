package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rva.jpa.Igrac;
import rva.repository.IgracRepository;

@RestController
public class IgracRestController {
	
	@Autowired
	private IgracRepository igracRepository;
	
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
}
