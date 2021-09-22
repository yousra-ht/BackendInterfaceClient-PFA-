package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

@Entity
@Table(name = "Filiere")
@ComponentScan()
public class Filiere {
		private long id ; 
		private String nom ;
		@Override
public String toString() {
			return "Filiere [id=" + id + ", nom=" + nom + "]";
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
		public String getNom() {
			return nom;
		}
@Column(nullable=false)
public void setNom(String nom) {
			this.nom = nom;
		}
}
