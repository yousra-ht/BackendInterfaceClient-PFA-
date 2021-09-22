package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class ReservationController {
	
	@PersistenceContext
	 private EntityManager entityManager ; 
	@Autowired
	private ReservationRepository  reservationRepository  ; 
	
	 @PostMapping("/reservation")
	 @CrossOrigin(origins ="http://localhost:4200")
	 @PreAuthorize("hasRole('ETUDIANT')")
	    public Reservation createreservation(@Validated @RequestBody Reservation reservation) {
	        return reservationRepository.save(reservation);
	    }
	 
	 
	 @RequestMapping("/reservation")
	 @PreAuthorize("hasRole('ETUDIANT')")
	 public List<Reservation> getAllreservatio() {
		
	         return reservationRepository.findAll();
	 }
	 
	 
	    @SuppressWarnings("unchecked")
		@RequestMapping("/checktime/{id}")
		 public  List<Reservation> getTime(@PathVariable(value = "id") Long Id)
		 {
	    	
			 
			 List<Reservation> List = new ArrayList<>() ;
			List =  entityManager.createNativeQuery("select *  from Reservation where tp="+Id , Reservation.class)
					.getResultList();
			return List;
			 
		
		 }
	 
}

