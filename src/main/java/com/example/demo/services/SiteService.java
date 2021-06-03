package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SiteRepository;
import com.example.demo.entities.Region;
import com.example.demo.entities.Site;
@Service
public class SiteService {
	@Autowired
	private SiteRepository siteRepository;
    @Autowired
	public SiteService(SiteRepository siteRepository) {
		this.siteRepository=siteRepository;
	}
	public List<Site> sites()
	{
	   return siteRepository.findAll();	
	}
	public Page<Site> rechercherSite(String mc,int indice,int taille)
	{
		return siteRepository.findByNomSiteContainsOrderByDateCreation(mc, PageRequest.of(indice,taille));
	}
	public Page<Site> rechercherParRegion(Region r,int indice,int taille)
	{
		return siteRepository.findByRegionOrderByDateCreation(r, PageRequest.of(indice,taille));
	}
	public Site UnSite(int id) 
	{
		return siteRepository.findById(id).get();
	}
	public Site AjouterSite(Site s) 
	{
		return siteRepository.save(s);
	}
	public Site ModifierSite(Site s,int id) 
	{
		s.setReference(id);
		return siteRepository.save(s);
	}
	public void SupprimerSite(int id) 
	{
		siteRepository.deleteById(id);
	}
}
