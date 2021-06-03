package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="site")
public class Site implements Serializable {
  @Id
  @GeneratedValue
  private Integer reference;
  @Column(name="nom")
  @NotBlank(message="renseigez le nom")
  private String nomSite;
  @Column(name="description",columnDefinition="text")
 @NotBlank(message="le champ Description ne doit pas être vide")
  private String description;
 @NotNull(message="Veillez entrer une date")
  @Column(name="date_creation")
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date dateCreation;
  @Column(name="tarif")
  @NotNull(message="le champ Tarif ne doit pas être vide")
  private double tarif;
  @Column(name="superfice")
  @NotNull(message="le champ Superfice ne doit pas être vide")
  private long superficie;
  @Column(name="capacite")
  @NotNull(message="le champ Capacite ne doit pas être vide")
  private int capacite;
  @ManyToOne
  private Region region;
  @OneToMany(mappedBy="site",fetch=FetchType.LAZY)
  private Collection<Section> sections;
public Site() {
	super();
	// TODO Auto-generated constructor stub
}
public Site(String nom, String description, Date dateCreation, double tarif, long superfice, int capacite,Region region) {
	this.nomSite = nom;
	this.description = description;
	this.dateCreation = dateCreation;
	this.tarif = tarif;
	this.superficie = superfice;
	this.capacite = capacite;
	this.region=region;
}
public Integer getReference() {
	return reference;
}
public void setReference(Integer reference) {
	this.reference = reference;
}
public String getNomSite() {
	return nomSite;
}
public void setNomSite(String nom) {
	nomSite = nom;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
public double getTarif() {
	return tarif;
}
public void setTarif(double tarif) {
	this.tarif = tarif;
}
public long getSuperficie() {
	return superficie;
}
public void setSuperficie(long superfice) {
	this.superficie = superfice;
}
public int getCapacite() {
	return capacite;
}
public void setCapacite(int capacite) {
	this.capacite = capacite;
}
public Region getRegion() {
	return region;
}
public void setRegion(Region region) {
	this.region = region;
}
  
}
