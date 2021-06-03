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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Section implements Serializable{
   @Id
   @GeneratedValue
   private Integer idSection;
   @Column(length=30)
   @NotBlank(message="Veillez remplir le champ")
   private String nomSection;
   @NotNull(message="Veillez remplir le champ")
   private int taille;
   @NotNull(message="Veillez remplir le champ")
   @Temporal(TemporalType.DATE)
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date dateCreation;
   @ManyToOne
   private Site site;
   @OneToMany(mappedBy="section",fetch=FetchType.EAGER)
   private Collection<Element> elements;
public Section() {
	super();
	// TODO Auto-generated constructor stub
}
public Section(String nom, int taille, Date dateCreation) {
	super();
	this.nomSection = nom;
	this.taille = taille;
	this.dateCreation = dateCreation;
}
public Integer getIdSection() {
	return idSection;
}
public void setIdSection(Integer idSection) {
	this.idSection = idSection;
}
public String getNomSection() {
	return nomSection;
}
public void setNomSection(String nom) {
	this.nomSection = nom;
}
public Site getSite() {
	return site;
}
public void setSite(Site site) {
	this.site = site;
}
public int getTaille() {
	return taille;
}
public void setTaille(int taille) {
	this.taille = taille;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
   
}
