package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Element;

public interface ElementRepository extends JpaRepository<Element, Integer> {
public Page<Element> findByNomContains(String mc,Pageable p);
}
