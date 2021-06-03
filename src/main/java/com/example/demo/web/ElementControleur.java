package com.example.demo.web;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Section;
import com.example.demo.entities.Element;
import com.example.demo.services.ElementService;
import com.example.demo.services.SectionService;
@Controller
@RequestMapping("/Elements")
public class ElementControleur {
	@Autowired
	private SectionService sectionService;
	@Autowired
	private ElementService elementService;
	
	@Value("${dir.imagesElement}")
	private String imagesDir;
	
	@RequestMapping("/index")
	public String index(Model modele) {
		List<Element> Elements=elementService.Elements();
    	modele.addAttribute("Elements",Elements);
		return "IndexElement";
	}
	
    @RequestMapping("/FormElement")
	public String formElement(Model modele) {
    	List<Section> sections = sectionService.sections();
    	modele.addAttribute("sections",sections);
    	modele.addAttribute("Element",new Element());
		return "formulaireElement";
	}
    
    @RequestMapping("/sauverElement")
 	public String sauverElement(@Valid Element s,Model modele, Errors errors, @RequestParam(name="photo") MultipartFile file) throws Exception, IOException {
    	if(errors.hasErrors()) {
    		return "formulaireElement";
    	}
    	elementService.AjouterElement(s);
    	if(!(file.isEmpty())) {
    		file.transferTo(new File(imagesDir+s.getReference()));
    	}
 		return "redirect:/Elements/index";
 	}
	  @RequestMapping(value = "/Editer")
		public String Editer(Model modele, @RequestParam(name = "reference") int id) {

	  	Element s = elementService.UnElement(id);
    	modele.addAttribute("Element",s);
    	List<Section> sections = sectionService.sections();
    	modele.addAttribute("sections",sections);
 		return "formulaireUpdateElement";
 	}
	  
	  @RequestMapping(value = "/ModifierElement")
		public String Modifier(Errors errors,@Valid Element s ) {
	  	if(errors.hasErrors()) {
	  		return "formulaireUpdateElement";
	  	}

	  	elementService.AjouterElement(s);
	  	return "redirect:/Elements/index";
	}
   
	  @RequestMapping(value="/Delete")
	    public String Delete(@RequestParam(name="id") int id) {
	    	elementService.SupprimerElement(id);
	    	return "redirect:/Elements/index";
	    }
	  
	  @RequestMapping(value = "/details")
		public String details(Model modele, @RequestParam(name = "id") int id) {

	  	Element s = elementService.UnElement(id);
	  	modele.addAttribute("Element",s);
			return "DetailsElement";
		}
	  
	  @RequestMapping(value="/getPhoto",produces=MediaType.IMAGE_JPEG_VALUE)
	    @ResponseBody
	    public byte[] getPhoto(Long id) throws IOException {
	    	return Files.readAllBytes(Paths.get(imagesDir+id));
	    }
}
