package com.example.demo.model;

import java.io.Serializable;

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
@Table(name = "group_tp ")
@ComponentScan()
public class GroupTp implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id ; 
	private String nom ;
	private Classe classe ; 
	private Enseignant  Enseigenant ; 
	private TravauxPratique TravauxPratique ;
	private long TP_id ; 
	
	
	
	 @Column(name = "TP_id")
	public long getTP_id() {
		return TP_id;
	}
	public void setTP_id(long tP_id) {
		TP_id = tP_id;
	}
	public GroupTp() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(nullable=false)
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="Classe_id")
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="enseignant_id")
	public Enseignant getEnseigenant() {
		return Enseigenant;
	}
	public void setEnseigenant(Enseignant enseigenant) {
		Enseigenant = enseigenant;
	}
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="TP_id", nullable=false, insertable=false, updatable=false)
	public TravauxPratique getTravauxPratique() {
		return TravauxPratique;
	}
	public void setTravauxPratique(TravauxPratique travauxPratique) {
		TravauxPratique = travauxPratique;
	}
	
	
	
	
	
}
