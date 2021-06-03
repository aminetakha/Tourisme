package com.example.demo.web;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Region;
import com.example.demo.services.RegionService;
@Controller
@RequestMapping("/region")
public class RegionControleur {
	@Autowired
	private RegionService regionService;
	
	@RequestMapping("/index")
	public String index(Model modele) {
		List<Region> regions=regionService.regions();
    	modele.addAttribute("regions",regions);
		return "IndexRegion";
	}
	
    @RequestMapping("/FormRegion")
	public String formRegion(Model modele) {
    	modele.addAttribute("region",new Region());
		return "formulaireRegion";
	}
    
    @RequestMapping("/FormUpdateRegion")
	public String formUpdateRegion(Model modele,@RequestParam(name = "idRegion") int id) {
    	Region r = regionService.UneRegion(id);
    	modele.addAttribute("region",r);
		return "formulaireUpdateRegion";
	}
    
    
    @RequestMapping("/DeleteRegion")
	public String DeleteRegion(@RequestParam(name = "idRegion") int id) {
    	regionService.SupprimerRegion(id);
		return "redirect:/sites/Index";
	}
    
    
    @RequestMapping("/sauverRegion")
 	public String sauverRegion(@Valid Region r,Model modele, Errors errors) {
    	if(errors.hasErrors()) {
    		return "formulaireRegion";
    	}
    	regionService.AjouterRegion(r);
 		return "redirect:/sites/Index";
 	}
    
    @RequestMapping("/UpdateRegion")
 	public String UpdateRegion(@Valid Region r,Model modele, Errors errors) {
    	if(errors.hasErrors()) {
    		return "formulaireUpdateRegion";
    	}
    	regionService.AjouterRegion(r);
 		return "redirect:/sites/Index";
 	}
    
    @RequestMapping("/details")
	public String details(Model modele, @RequestParam(name = "idRegion") int id) {
		Region r = regionService.UneRegion(id);
    	modele.addAttribute("r",r);
		return "DetailsRegion";
	}
}
