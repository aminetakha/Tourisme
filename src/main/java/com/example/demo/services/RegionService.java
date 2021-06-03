package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.demo.dao.RegionRepository;
import com.example.demo.entities.Region;
@Service
public class RegionService {
	@Autowired
	private RegionRepository regionRepository;
    
	public List<Region> regions()
	{
	   return regionRepository.findAll();	
	}
	public Page<Region> rechercherRegion(String mc,int indice,int taille)
	{
		return regionRepository.findByNomContains(mc, PageRequest.of(indice,taille));
	}
	public Region UneRegion(int id) 
	{
		return regionRepository.findById(id).get();
	}
	public Region AjouterRegion(Region r) 
	{
		return regionRepository.save(r);
	}
	public Region ModifierRegion(Region r,int id) 
	{
		r.setIdRegion(id);
		return regionRepository.save(r);
	}
	public void SupprimerRegion(int id) 
	{
		regionRepository.deleteById(id);
	}
}
