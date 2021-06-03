package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Region;
import com.example.demo.entities.Site;

public interface SiteRepository extends JpaRepository<Site, Integer> {
//public List<Site> findByNomContains(String mc);
public Page<Site> findByNomSiteContainsOrderByDateCreation(String mc,Pageable p);
public Page<Site> findByRegionOrderByDateCreation(Region r,Pageable p);
}
