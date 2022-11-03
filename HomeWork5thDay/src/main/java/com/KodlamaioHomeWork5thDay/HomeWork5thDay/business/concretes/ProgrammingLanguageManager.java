package com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.abstracts.ProgrammingLanguageService;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.CreateProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.GetAllProgrammingLanguagesResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.entities.concretes.ProgrammingLanguage;


public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;		
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = new ArrayList<GetAllProgrammingLanguagesResponse>();
		
		for(ProgrammingLanguage programmingLanguage:programmingLanguages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			programmingLanguagesResponse.add(responseItem);
		}
		
		return programmingLanguagesResponse;
	}

	
	
	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage=new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		this.programmingLanguageRepository.save(programmingLanguage);
	}
}