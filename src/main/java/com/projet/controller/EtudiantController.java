package com.projet.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.exception.ResourceNotFoundException;
import com.projet.model.Etudiant;
import com.projet.repository.EtudiantRepository;


	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api")
	public class EtudiantController {
		@Autowired 	EtudiantRepository repository;
		 @GetMapping("/etudiants")
		  public List<Etudiant> getAllEtudiants() {
		    System.out.println("Get all Students...");
		 
		    List<Etudiant> Etudiant = new ArrayList<>();
		    repository.findAll().forEach(Etudiant::add);
		 
		    return Etudiant;
		  }
		
		@GetMapping("/etudiants/{id}")
		public ResponseEntity<Etudiant> getClientByCode(@PathVariable(value = "id") int id)
				throws ResourceNotFoundException {
			 System.out.println(id);
			 
			Etudiant etudiant = repository.findByCode(id)
					.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
			return ResponseEntity.ok().body(etudiant);
		}

		@PostMapping("/etudiants")
		public Etudiant createClient(@Valid @RequestBody Etudiant Etudiant) {
			
	 		return repository.save(Etudiant);
		}
		

		@DeleteMapping("/etudiants/{id}")
		public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long etudiantid)
				throws ResourceNotFoundException {
			Etudiant etudiant = repository.findById(etudiantid)
					.orElseThrow(() -> new ResourceNotFoundException("student not found  id :: " + etudiantid));

			repository.delete(etudiant);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
		  
		 
		  @DeleteMapping("/etudiants/delete")
		  public ResponseEntity<String> deleteAllEtudiants() {
		    System.out.println("Delete All Students...");
		 
		    repository.deleteAll();
		 
		    return new ResponseEntity<>("All Students have been deleted!", HttpStatus.OK);
		  }
		 
		

		  @PutMapping("/student/{id}")
		  public ResponseEntity<Etudiant> updateClient(@PathVariable("id") long id, @RequestBody Etudiant etudiant) {
		    System.out.println("Update Etudiant with ID = " + id + "...");
		 
		    Optional<Etudiant> EtudiantInfo = repository.findById(id);
		 
		    if (EtudiantInfo.isPresent()) {
		    	Etudiant Etudiant  = EtudiantInfo.get();
		          
		           etudiant.setAdresse(Etudiant.getAdresse());
		         
		           etudiant.setEmail(Etudiant.getEmail());
		           etudiant.setLogin(Etudiant.getLogin());
		          
		           etudiant.setPwd(Etudiant.getPwd());
		           
		           etudiant.setTel(Etudiant.getTel());
		          
		          
		      return new ResponseEntity<>(repository.save(Etudiant), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		  }

	}

