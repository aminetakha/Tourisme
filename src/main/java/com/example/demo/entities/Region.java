package com.example.demo.entities;
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="region")
public class Region implements Serializable {
	@Id
	@GeneratedValue
    private Integer idRegion;
	@Column(name="nom",length=30)
	@NotBlank(message="Le champ ne doit pa être vide")
    private String nom;
	@Column(name="superficie")
	@NotNull(message="Le champ superficie ne doit pa être vide")
    private long superficie;
	@Column(name="population")
	@NotNull(message="Le champ population ne doit pa être vide")
    private long population;
	@Column(name="langue",length=30)
	@NotBlank(message="Le champ langue ne doit pa être vide")
    private String langue;
	@Column(name="devise",length=30)
	@NotBlank(message="Le champ devise ne doit pa être vide")
    private String devise;
	@OneToMany(mappedBy="region",fetch=FetchType.LAZY)
	private Collection<Site> sites;
    public Region() {
	super();
	// TODO Auto-generated constructor stub
}
public Region(String nom, long superficie, long population, String langue, String devise) {
	super();
	this.nom = nom;
	this.superficie = superficie;
	this.population = population;
	this.langue = langue;
	this.devise = devise;
}
public Integer getIdRegion() {
	return idRegion;
}
public void setIdRegion(Integer idRegion) {
	this.idRegion = idRegion;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public long getSuperficie() {
	return superficie;
}
public void setSuperficie(long superficie) {
	this.superficie = superficie;
}
public long getPopulation() {
	return population;
}
public void setPopulation(long population) {
	this.population = population;
}
public String getLangue() {
	return langue;
}
public void setLangue(String langue) {
	this.langue = langue;
}
public String getDevise() {
	return devise;
}
public void setDevise(String devise) {
	this.devise = devise;
}

}
