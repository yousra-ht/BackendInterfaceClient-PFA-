package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

@Entity
@Table(name = "classe_etudiant")
@ComponentScan()
public class classe_etudiant  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long classe_id ; 
	private String etudiant_id ;
	public classe_etudiant() {
		super();
	}
	@Id
	 @Column(name = "classe_id")
	public long getClasse_id() {
		return classe_id;
	}
	public void setClasse_id(long classe_id) {
		this.classe_id = classe_id;
	}
	@Id
	@Column(name = "etudiant_id")
	public String getEtudiant_id() {
		return etudiant_id;
	}
	public void setEtudiant_id(String etudiant_id) {
		this.etudiant_id = etudiant_id;
	}
	
	
}
