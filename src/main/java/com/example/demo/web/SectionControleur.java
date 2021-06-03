package com.example.demo.web;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Region;
import com.example.demo.entities.Section;
import com.example.demo.entities.Site;
import com.example.demo.services.RegionService;
import com.example.demo.services.SectionService;
import com.example.demo.services.SiteService;
@Controller
@RequestMapping("/sections")
public class SectionControleur {
	@Autowired
	private SectionService sectionService;
	@Autowired
	private SiteService siteService;
	
	@RequestMapping("/index")
	public String index(Model modele) {
		List<Section> sections=sectionService.sections();
    	modele.addAttribute("sections",sections);
		return "IndexSection";
	}
	
    @RequestMapping("/FormSection")
	public String formSection(Model modele) {
    	List<Site> sites = siteService.sites();
    	modele.addAttribute("sites",sites);
    	modele.addAttribute("section",new Section());
		return "formulaireSection";
	}
    
    @RequestMapping("/sauverSection")
 	public String sauverSection(@Valid Section s,Model modele, Errors errors) {
    	if(errors.hasErrors()) {
    		return "formulaireSection";
    	}
    	sectionService.AjouterSection(s);
 		return "redirect:/sections/index";
 	}
	  @RequestMapping(value = "/Editer")
		public String Editer(Model modele, @RequestParam(name = "idSection") int id) {

	  	Section s = sectionService.UneSection(id);
    	modele.addAttribute("section",s);
    	List<Site> sites = siteService.sites();
    	modele.addAttribute("sites",sites);
 		return "formulaireSection";
 	}
	  
	  @RequestMapping(value = "/ModifierSection")
		public String Modifier(Model modele, Errors errors,@Valid Section s ) {
	  	if(errors.hasErrors()) {
	  		return "formulaireUpdateSection";
	  	}

	  	sectionService.AjouterSection(s);
	  	return "redirect:/sections/index";
	}
   
	  @RequestMapping(value="/Delete")
	    public String Delete(@RequestParam(name="idSection") int id) {
	    	sectionService.SupprimerSection(id);
	    	return "redirect:/sections/index";
	    }
	  
	  @RequestMapping(value = "/details")
		public String details(Model modele, @RequestParam(name = "idSection") int id) {

	  	Section s = sectionService.UneSection(id);
	  	modele.addAttribute("section",s);
			return "DetailsSection";
		}
}
