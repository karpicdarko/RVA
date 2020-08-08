package rva.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.jpa.*;

public interface LigaRepository extends JpaRepository<Liga, Integer> {
	
	Collection<Liga> findByNazivContainingIgnoreCase(String naziv);
	Collection<Liga> findByOznakaContainingIgnoreCase(String oznaka);
}
