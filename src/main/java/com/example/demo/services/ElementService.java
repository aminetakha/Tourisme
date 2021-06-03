package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ElementRepository;
import com.example.demo.dao.ElementRepository;
import com.example.demo.entities.Element;
@Service
public class ElementService {
	@Autowired
	private ElementRepository elementRepository;
    
	public List<Element> Elements()
	{
	   return elementRepository.findAll();	
	}
	public Page<Element> rechercherElement(String mc,int indice,int taille)
	{
		return elementRepository.findByNomContains(mc, PageRequest.of(indice,taille));
	}
	public Element UnElement(int id) 
	{
		return elementRepository.findById(id).get();
	}
	public Element AjouterElement(Element s) 
	{
		return elementRepository.save(s);
	}
	public Element ModifierElement(Element s,int id) 
	{
		s.setReference(id);
		return elementRepository.save(s);
	}
	public void SupprimerElement(int id) 
	{
		elementRepository.deleteById(id);
	}
}
