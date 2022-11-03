package com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.concretes;

import java.util.ArrayList;
import java.util.List;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.abstracts.SubTechnologyService;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.CreateSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.GetAllSubTechnologiesResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.dataAccess.abstracts.SubTechnologyRepository;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.entities.concretes.SubTechnology;

public class SubTechnologyManager implements SubTechnologyService {
	private SubTechnologyRepository subTechnologyRepository;
	
	
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository) {
		this.subTechnologyRepository = subTechnologyRepository;
	}

	@Override
	public List<GetAllSubTechnologiesResponse> getAll() {
		List<SubTechnology> subTechnologies = subTechnologyRepository.findAll();
		List<GetAllSubTechnologiesResponse> subTechnologiesResponse = new ArrayList<GetAllSubTechnologiesResponse>();
		
		for (SubTechnology subTechnology : subTechnologies) {
			GetAllSubTechnologiesResponse responseItem = new GetAllSubTechnologiesResponse();
			responseItem.setId(subTechnology.getId());
			responseItem.setName(subTechnology.getName());
			subTechnologiesResponse.add(responseItem);
		}
		return subTechnologiesResponse;
	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		SubTechnology subTechnology = new SubTechnology();
		subTechnology.setName(createSubTechnologyRequest.getName());
		this.subTechnologyRepository.save(subTechnology);
	}
}