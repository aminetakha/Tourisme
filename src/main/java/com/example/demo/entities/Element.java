package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
public class Element implements Serializable {
	@Id
	@GeneratedValue
    private Integer reference;
	@Column(length=30)
	@NotBlank(message="veillez remplir le champ")
    private String nom;
	@Column(columnDefinition="text")
	@NotBlank(message="veillez remplir le champ")
    private String description;
	@NotNull(message="veillez remplir le champ")
    private int age;
	@NotNull(message="veillez remplir le champ")
    private double valeur;
	@ManyToOne
	private Section section;
	
	public Element() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Element(@NotBlank(message = "veillez remplir le champ") String nom,
			@NotBlank(message = "veillez remplir le champ") String description,
			@NotBlank(message = "veillez remplir le champ") int age,
			@NotBlank(message = "veillez remplir le champ") double valeur) {
		super();
		this.nom = nom;
		this.description = description;
		this.age = age;
		this.valeur = valeur;
	}
	
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public Integer getReference() {
		return reference;
	}
	public void setReference(Integer reference) {
		this.reference = reference;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
     
}
