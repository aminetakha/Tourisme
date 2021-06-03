package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Integer> {
public Page<Section> findByNomSectionContains(String mc,Pageable p);
}
