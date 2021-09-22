package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Reservation")
@ComponentScan()
public class Reservation {
	private long Id; 
	private String motdepass ; 
	private String debut ;
	private String fin ;
	private TravauxPratique tp ; 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="tp")
	public TravauxPratique getTp() {
		return tp ;
	}
	public void setTp(TravauxPratique tp ) {
		this.tp = tp;
	}
	@Column(nullable=false)
	public String getMotdepass() {
		return motdepass;
	}
	public void setMotdepass(String motdepass) {
		this.motdepass = motdepass;
	}
	@Column(nullable=false)
	public String  getDebut() {
		return debut;
	}
	public void setDebut(String  debut) {
		this.debut = debut;
	}
	@Column(nullable=false)
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	@Override
	public String toString() {
		return "Reservation [Id=" + Id + ", motdepass=" + motdepass + ", debut=" + debut + ", fin=" + fin + "]";
	}
	
	
}
