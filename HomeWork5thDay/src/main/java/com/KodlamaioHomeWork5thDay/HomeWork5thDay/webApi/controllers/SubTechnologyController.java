package com.KodlamaioHomeWork5thDay.HomeWork5thDay.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.abstracts.SubTechnologyService;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.CreateSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.GetAllSubTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class SubTechnologyController {
	private SubTechnologyService subTechnologyService;
	
	@Autowired
	public SubTechnologyController(SubTechnologyService subTechnologyService) {
		this.subTechnologyService = subTechnologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllSubTechnologiesResponse> getAll(){
		return subTechnologyService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateSubTechnologyRequest createSubTechnologyRequest) {
		this.subTechnologyService.add(createSubTechnologyRequest);
	}
}