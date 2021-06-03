package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SectionRepository;
import com.example.demo.entities.Section;
@Service
public class SectionService {
	@Autowired
	private SectionRepository  sectionRepository;
    
	public List<Section> sections()
	{
	   return sectionRepository.findAll();	
	}
	public Page<Section> rechercherSection(String mc,int indice,int taille)
	{
		return sectionRepository.findByNomSectionContains(mc, PageRequest.of(indice,taille));
	}
	public Section UneSection(int id) 
	{
		return sectionRepository.findById(id).get();
	}
	public Section AjouterSection(Section s) 
	{
		return sectionRepository.save(s);
	}
	public Section ModifierSection(Section s,int id) 
	{
		s.setIdSection(id);
		return sectionRepository.save(s);
	}
	public void SupprimerSection(int id) 
	{
		sectionRepository.deleteById(id);
	}
}
