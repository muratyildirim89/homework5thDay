package com.KodlamaioHomeWork5thDay.HomeWork5thDay.webApi.controllers;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.abstracts.ProgrammingLanguageService;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.programmingLanguage.GetByIdProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.GetProgrammingLanguageDetailsResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.UpdateProgrammingLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguageController {
    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @PostMapping("/add")
    public void add(@RequestBody() CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws RuntimeException {
        this.programmingLanguageService.add(createProgrammingLanguageRequest);
    }

    @PutMapping("/update")
    public UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws RuntimeException {
        return programmingLanguageService.update(updateProgrammingLanguageRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
        this.programmingLanguageService.delete(deleteProgrammingLanguageRequest);
    }

    @GetMapping("/getbyid")
    public GetByIdProgrammingLanguageResponse getById(GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest) {
        return programmingLanguageService.getById(getByIdProgrammingLanguageRequest);
    }

    @GetMapping("/getall")
    public List<GetProgrammingLanguageDetailsResponse> getAll() {
        return programmingLanguageService.getAll();
    }
}