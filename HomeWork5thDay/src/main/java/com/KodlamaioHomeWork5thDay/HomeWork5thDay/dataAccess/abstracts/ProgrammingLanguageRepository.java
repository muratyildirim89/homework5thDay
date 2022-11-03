package com.KodlamaioHomeWork5thDay.HomeWork5thDay.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer>{

}
