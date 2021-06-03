package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {
public Page<Region> findByNomContains(String mc,Pageable p);
}
