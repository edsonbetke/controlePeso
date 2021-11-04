package com.edsonb.controlepeso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edsonb.controlepeso.domain.Peso;

@Repository
public interface PesoRepository extends JpaRepository<Peso, Integer> {

}
