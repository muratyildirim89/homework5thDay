package com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.abstracts;

import java.util.List;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.CreateSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.GetAllSubTechnologiesResponse;

public interface SubTechnologyService {
	List<GetAllSubTechnologiesResponse> getAll();
	void add(CreateSubTechnologyRequest createSubTechnologyRequest);
}
