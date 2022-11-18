package com.KodlamaioHomeWork5thDay.HomeWork5thDay.webApi.controllers;

import java.util.List;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.subTechnology.DeleteSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.subTechnology.GetByIdSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.subTechnology.UpdateSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology.DeleteSubTechnologyResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology.GetByIdSubTechnologyResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology.UpdateSubTechnologyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.abstracts.SubTechnologyService;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.subTechnology.CreateSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology.GetSubTechnologyDetailsResponse;

@RestController
@RequestMapping("/api/technologies")
public class SubTechnologyController {
    private SubTechnologyService subTechnologyService;

    @Autowired
    public SubTechnologyController(SubTechnologyService subTechnologyService) {
        this.subTechnologyService = subTechnologyService;
    }

    //CRUD Operations
    @PostMapping("/add")
    public void add(@RequestBody() CreateSubTechnologyRequest createSubTechnologyRequest) {
        this.subTechnologyService.add(createSubTechnologyRequest);
    }

    @PutMapping("/update")
    public UpdateSubTechnologyResponse update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws RuntimeException {
        return subTechnologyService.update(updateSubTechnologyRequest);
    }

    @DeleteMapping("/delete")
    public DeleteSubTechnologyResponse delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
        return subTechnologyService.delete(deleteSubTechnologyRequest);
    }

    //Get Methods
    @GetMapping("/getbyid")
    public GetByIdSubTechnologyResponse getById(GetByIdSubTechnologyRequest getByIdSubTechnologyRequest) {
        return subTechnologyService.getById(getByIdSubTechnologyRequest);
    }

    @GetMapping("/getall")
    public List<GetSubTechnologyDetailsResponse> getAll() {
        return subTechnologyService.getAll();
    }
}