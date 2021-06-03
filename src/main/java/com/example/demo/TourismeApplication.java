package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.SiteRepository;
import com.example.demo.entities.Region;
import com.example.demo.entities.Site;
import com.example.demo.services.RegionService;
import com.example.demo.services.SiteService;

@SpringBootApplication
public class TourismeApplication implements CommandLineRunner{
   @Autowired
   private SiteService service;
   @Autowired
   private RegionService regionService;
	public static void main(String[] args) {
		SpringApplication.run(TourismeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*service.AjouterSite(new Site("Mosque Agadez", "Historique", new Date(1005-06-04),
				1270,1000, 5000,));
		service.AjouterSite(new Site("Zoo", "Rabat", new Date(2001-02-04),
				200,1400, 5000));
		service.AjouterSite(new Site("Sultana zinder", "Zinder", new Date(2001-02-04),
				200,1400, 5000));
		service.AjouterSite(new Site("SUltana du gobir", "Rabat", new Date(2001-02-04),
				200,1400, 5000));*/
		/*regionService.AjouterRegion(new Region("Zinder",350000, 330000,"Hausa","Franc CFA"));
		regionService.AjouterRegion(new Region("Tanger-Tetouan-Houceima",150000, 400000,"Arabe-Amazig-Français","MAD"));
		regionService.AjouterRegion(new Region("Paris",10000,20000,"Français","Franc français"));
         */
	}

}
