package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.SiteRepository;
import com.example.demo.services.SiteService;

@Controller
public class TourismeControleur {
	@Autowired
	private SiteService service;
	@RequestMapping("/")
	public String Index(@RequestParam(name="page",defaultValue="0") int page,
	           @RequestParam(name="size",defaultValue="4") int size,
	           @RequestParam(name="mc",defaultValue="") String mc,
	           Model modele) {
		modele.addAttribute("sites",service.rechercherSite(mc, page,size));
		return "Index";
	}
	
	
}
