package com.example.demo.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Region;
import com.example.demo.entities.Site;
import com.example.demo.services.RegionService;
import com.example.demo.services.SiteService;

@Controller
@RequestMapping("/sites")
public class SiteControleur {
	@Autowired
	private SiteService service;
	@Autowired
	private RegionService regionService;
	@Value("${dir.images}")
	private String imagesDir;
    @RequestMapping("/Index")
	public String Index(@RequestParam(name="page",defaultValue="0") int page,
	           @RequestParam(name="size",defaultValue="8") int size,
	           @RequestParam(name="mc", defaultValue="") String mc,
	           @RequestParam(name="idRegion",defaultValue="0") int idRegion
	           ,Model modele) {
    	List<Region> regions =regionService.regions();
    	modele.addAttribute("regions",regions);
    	Page<Site> sites=service.rechercherSite(mc,page,size);
    	if(idRegion!=0) {
    		Region r1=regionService.UneRegion(idRegion);
    		sites=service.rechercherParRegion(r1,page,size);	
    	}
        modele.addAttribute("sites",sites.getContent());
        modele.addAttribute("pages",new int[sites.getTotalPages()]);
        modele.addAttribute("pageCourante",page);
        modele.addAttribute("mc",mc);
		return "AffichageSite";
	}
    @RequestMapping(value="/FormSite",method=RequestMethod.GET)
    public String Ajout( Model modele) {
    	List<Region> regions=regionService.regions();
    	modele.addAttribute("regions",regions);
    	modele.addAttribute("site",new Site());
    	return "FormSite";
    }
    @RequestMapping(value="/FormSite",method=RequestMethod.POST)
    public String Sauver(@RequestParam(name="region") int idRegion,@Valid Site site,
    		Errors errors ,Model modele,
    		@RequestParam(name="photo") MultipartFile file) throws Exception, IOException {
    	Region r=regionService.UneRegion(idRegion);
    	site.setRegion(r);
    	if(errors.hasErrors()) {
    		 r=regionService.UneRegion(idRegion);
        	site.setRegion(r);
    		return "FormSite";
    	}
    	service.AjouterSite(site);
    	if(!(file.isEmpty())) {
    		file.transferTo(new File(imagesDir+site.getReference()));
    	}
    	
    	return "redirect:/sites/Index";
    }
    @RequestMapping(value="/Delete")
    public String Delete(@RequestParam(name="id") int id) {
    	service.SupprimerSite(id);
    	return "redirect:/sites/Index";
    }
    @RequestMapping(value="/Details")
    public String Details(@RequestParam(name="id") int id,Model modele) {
    	Site site=service.UnSite(id);
    	modele.addAttribute("s",site);
    	return "Details";
    }
    @RequestMapping(value="/Editer")
    public String Editer(@RequestParam(name="id") int id,Model modele) {
    	Site site=service.UnSite(id);
    	List<Region> regions=regionService.regions();
    	modele.addAttribute("regions",regions);
    	modele.addAttribute("site",site);
    	return "FormUpdateSite";
    }
    @RequestMapping(value="/Update",method=RequestMethod.POST)
    public String Update(@RequestParam(name="region") int idRegion,@Valid Site site,
    		Errors errors ,Model modele,
    		@RequestParam(name="photo") MultipartFile file) throws Exception, IOException {
    	Region r=regionService.UneRegion(idRegion);
    	site.setRegion(r);
    	if(errors.hasErrors()) {
    		return "FormUpdateSite";
    	}
    	service.ModifierSite(site,site.getReference());
    	if(!(file.isEmpty())) {
    		file.transferTo(new File(imagesDir+site.getReference()));
    	}
    	return "redirect:/sites/Index";
    }
    
    @RequestMapping(value="/getPhoto",produces=MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getPhoto(Long id) throws IOException {
    	return Files.readAllBytes(Paths.get(imagesDir+id));
    }
}
