package com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.abstracts;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.programmingLanguage.GetByIdProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.DeleteProgrammingLanguageResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.GetProgrammingLanguageDetailsResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.UpdateProgrammingLanguageResponse;
import org.webjars.NotFoundException;

import java.util.List;

public interface ProgrammingLanguageService {
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws RuntimeException;

    public UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws RuntimeException;

    public DeleteProgrammingLanguageResponse delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);

    public GetByIdProgrammingLanguageResponse getById(GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest) throws NotFoundException;

    public List<GetProgrammingLanguageDetailsResponse> getAll();
}