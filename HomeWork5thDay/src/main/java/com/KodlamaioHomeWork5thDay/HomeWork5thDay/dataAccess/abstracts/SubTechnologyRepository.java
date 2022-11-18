package com.KodlamaioHomeWork5thDay.HomeWork5thDay.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.entities.concretes.SubTechnology;

public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Integer> {

}
