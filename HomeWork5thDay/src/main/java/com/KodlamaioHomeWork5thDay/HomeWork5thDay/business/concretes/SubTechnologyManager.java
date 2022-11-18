package com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.concretes;

import java.util.ArrayList;
import java.util.List;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.subTechnology.DeleteSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.subTechnology.GetByIdSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.subTechnology.UpdateSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology.DeleteSubTechnologyResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology.GetByIdSubTechnologyResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology.UpdateSubTechnologyResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.abstracts.SubTechnologyService;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.subTechnology.CreateSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.GetProgrammingLanguageDetailsResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology.GetSubTechnologyDetailsResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.dataAccess.abstracts.SubTechnologyRepository;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.entities.concretes.ProgrammingLanguage;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.entities.concretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService {
    private SubTechnologyRepository subTechnologyRepository;
    private ModelMapper modelMapper;


    public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository, ModelMapper modelMapper) {
        this.subTechnologyRepository = subTechnologyRepository;
        this.modelMapper = modelMapper;
    }

    //CRUD Operations
    @Override
    public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
        //CheckName(createSubTechnologyRequest.getName());

        SubTechnology subTechnology = new SubTechnology();
        subTechnology.setName(createSubTechnologyRequest.getName());
        subTechnology
                .setProgrammingLanguage(new ProgrammingLanguage(createSubTechnologyRequest
                        .getTechnologyId(), null, null));
        this.subTechnologyRepository.save(subTechnology);
    }

    @Override
    public UpdateSubTechnologyResponse update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws RuntimeException {
        //CheckName(updateSubTechnologyRequest.getName());

        SubTechnology subTechnology = modelMapper
                .map(updateSubTechnologyRequest, SubTechnology.class);
        SubTechnology saveSubTechnology = subTechnologyRepository.save(subTechnology);

        UpdateSubTechnologyResponse updateSubTechnologyResponse = modelMapper
                .map(saveSubTechnology, UpdateSubTechnologyResponse.class);

        return updateSubTechnologyResponse;
    }

    @Override
    public DeleteSubTechnologyResponse delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
        SubTechnology getReferenceByIdSubTechnologyResult = subTechnologyRepository
                .getReferenceById(deleteSubTechnologyRequest.getId());
        subTechnologyRepository.delete(getReferenceByIdSubTechnologyResult);

        DeleteSubTechnologyResponse deleteSubTechnologyResponse = modelMapper
                .map(getReferenceByIdSubTechnologyResult, DeleteSubTechnologyResponse.class);

        return deleteSubTechnologyResponse;
    }

    //Get Methods
    @Override
    public GetByIdSubTechnologyResponse getById(GetByIdSubTechnologyRequest getByIdSubTechnologyRequest) {

        SubTechnology getReferenceByIdSubTechnologyResult = subTechnologyRepository
                .getReferenceById(getByIdSubTechnologyRequest.getId());
        GetByIdSubTechnologyResponse getByIdSubTechnologyResponse = modelMapper
                .map(getReferenceByIdSubTechnologyResult, GetByIdSubTechnologyResponse.class);

        return getByIdSubTechnologyResponse;
        //subTechnologyRepository.findById(id)
        //.orElseThrow(() -> new RuntimeException("Sub Technology Not Found"));
    }

    @Override
    public List<GetSubTechnologyDetailsResponse> getAll() {
        List<SubTechnology> subTechnologies = subTechnologyRepository.findAll();
        List<GetSubTechnologyDetailsResponse> subTechnologiesResponse = new ArrayList<GetSubTechnologyDetailsResponse>();

        for (SubTechnology subTechnology : subTechnologies) {
            GetSubTechnologyDetailsResponse responseItem = new GetSubTechnologyDetailsResponse();
            responseItem.setId(subTechnology.getId());
            responseItem.setName(subTechnology.getName());
            GetProgrammingLanguageDetailsResponse technology = new GetProgrammingLanguageDetailsResponse(subTechnology.getProgrammingLanguage().getId(), subTechnology.getProgrammingLanguage().getName());
            responseItem.setTechnology(technology);
            subTechnologiesResponse.add(responseItem);
        }
        return subTechnologiesResponse;
    }

    // Business Rules
    public boolean CheckName(String checkedNameMethods) throws RuntimeException {
        return false;
    }

}