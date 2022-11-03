package com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.abstracts;

import java.util.List;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.CreateProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.GetAllProgrammingLanguagesResponse;

public interface ProgrammingLanguageService {
	List<GetAllProgrammingLanguagesResponse> getAll();
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
}
