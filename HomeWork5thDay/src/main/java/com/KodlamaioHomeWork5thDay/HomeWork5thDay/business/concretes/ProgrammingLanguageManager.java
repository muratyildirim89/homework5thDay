package com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.concretes;

import java.util.List;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.programmingLanguage.GetByIdProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.DeleteProgrammingLanguageResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.UpdateProgrammingLanguageResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import org.springframework.stereotype.Service;


import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.abstracts.ProgrammingLanguageService;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.GetProgrammingLanguageDetailsResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.entities.concretes.ProgrammingLanguage;
import org.webjars.NotFoundException;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    private ProgrammingLanguageRepository programmingLanguageRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository, ModelMapper modelMapper) {
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.modelMapper = modelMapper;
    }

    // CRUD Operations
    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName(createProgrammingLanguageRequest.getName());
        this.programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws RuntimeException {

        ProgrammingLanguage programmingLanguage = modelMapper
                .map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
        ProgrammingLanguage saveProgrammingLanguageResult = programmingLanguageRepository
                .save(programmingLanguage);

        UpdateProgrammingLanguageResponse updateProgrammingLanguageResponse = modelMapper
                .map(saveProgrammingLanguageResult, UpdateProgrammingLanguageResponse.class);
        return updateProgrammingLanguageResponse;
    }

    @Override
    public DeleteProgrammingLanguageResponse delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {

        ProgrammingLanguage getReferenceByIdProgrammingLanguageResult = programmingLanguageRepository
                .getReferenceById(deleteProgrammingLanguageRequest.getId());
        programmingLanguageRepository.delete(getReferenceByIdProgrammingLanguageResult);

        DeleteProgrammingLanguageResponse deleteProgrammingLanguageResponse = modelMapper
                .map(getReferenceByIdProgrammingLanguageResult, DeleteProgrammingLanguageResponse.class);

        return deleteProgrammingLanguageResponse;
    }

    // Get Methods
    @Override
    public GetByIdProgrammingLanguageResponse getById(GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest) throws NotFoundException {
        //checkName(programmingLanguageRepository.findById(id).get().getName());

        ProgrammingLanguage getReferenceByIdProgrammingLanguageResult = programmingLanguageRepository
                .getReferenceById(getByIdProgrammingLanguageRequest.getId());

        GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = modelMapper
                .map(getReferenceByIdProgrammingLanguageResult,
                        GetByIdProgrammingLanguageResponse.class);

        return getByIdProgrammingLanguageResponse;

        //programmingLanguageRepository.findById(id);


/*
        ProgrammingLanguage getReferenceByIdProgrammingLanguageResult = programmingLanguageRepository
                .getReferenceById(getByIdProgrammingLanguageRequest.getId());

        GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = modelMapper
                .map(getReferenceByIdProgrammingLanguageResult, GetByIdProgrammingLanguageResponse.class);

        return getByIdProgrammingLanguageResponse;*/
    }

    @Override
    public List<GetProgrammingLanguageDetailsResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();


        /*
        List<GetProgrammingLanguageDetailsResponse> programmingLanguagesResponse = new ArrayList<GetProgrammingLanguageDetailsResponse>();

        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            GetProgrammingLanguageDetailsResponse responseItem = new GetProgrammingLanguageDetailsResponse();
            responseItem.setId(programmingLanguage.getId());
            responseItem.setName(programmingLanguage.getName());
            programmingLanguagesResponse.add(responseItem);
        }
        return programmingLanguagesResponse;*/

        return modelMapper
                .map(programmingLanguages, new TypeToken<List<GetProgrammingLanguageDetailsResponse>>() {
                }
                        .getType());
    }

    //Business Rules
    private boolean checkName(String name) throws RuntimeException {
        return false;
    }
    /* MapStruct teknolojisini araştır ModelMap yerine 17.11.2022 */
}