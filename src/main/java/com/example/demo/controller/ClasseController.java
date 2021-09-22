package com.example.demo.controller;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GroupTp;
import com.example.demo.model.TravauxPratique;




@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api/v4")
public class ClasseController {
	
	
	@PersistenceContext
	 private EntityManager entityManager ; 
	 
	
	
	 @PreAuthorize("hasRole('ETUDIANT')")
	 @RequestMapping("/classe/{id}")
	 public  long getClasse(@PathVariable(value = "id") Long classeId)
	 {
		
		long id =  (long) entityManager.createQuery("select classe_id from classe_etudiant where etudiant_id=" +classeId   )
				.getSingleResult();
		 return  id ; 
	 }

	 
	 @SuppressWarnings("unchecked")
	 @PreAuthorize("hasRole('ETUDIANT')")
	 @RequestMapping("/Tps/{id}")
	 public  List<TravauxPratique> getidTp(@PathVariable(value = "id") Long classeId)
	 {
		 Long classe = classeId ; 
		 List<TravauxPratique> List = new ArrayList<>() ;
		List =  entityManager.createNativeQuery("select * from group_tp where classe_id <= :classe" , GroupTp.class)
				.setParameter("classe", classe)
				.getResultList();
		 
		 return List ; 
		
	 }
	 
	 @SuppressWarnings("unchecked")
	@PreAuthorize("hasRole('ETUDIANT')")
	 @RequestMapping("/dataTP/{id}")
		 public   List<TravauxPratique>  getTP(@PathVariable(value = "id") Long TPId)
		 {
		 List<TravauxPratique> List = new ArrayList<>() ;
		 List= entityManager.createNativeQuery("select *"
				 		+ " from travaux_pratique where id=" +TPId , TravauxPratique.class ).getResultList();
				
		 return List ; 
			 }
			 
}
