package com.KodlamaioHomeWork5thDay.HomeWork5thDay.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.abstracts.ProgrammingLanguageService;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.CreateProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.GetAllProgrammingLanguagesResponse;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguageController {
	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		this.programmingLanguageService.add(createProgrammingLanguageRequest);
	}
}