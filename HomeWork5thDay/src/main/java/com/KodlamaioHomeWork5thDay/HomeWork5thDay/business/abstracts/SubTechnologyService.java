package com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.abstracts;

import java.util.List;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.subTechnology.CreateSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.subTechnology.DeleteSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.subTechnology.GetByIdSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.requests.subTechnology.UpdateSubTechnologyRequest;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology.DeleteSubTechnologyResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology.GetByIdSubTechnologyResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology.GetSubTechnologyDetailsResponse;
import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology.UpdateSubTechnologyResponse;

public interface SubTechnologyService {
    public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws RuntimeException;

    public UpdateSubTechnologyResponse update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws RuntimeException;

    public DeleteSubTechnologyResponse delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest);

    public GetByIdSubTechnologyResponse getById(GetByIdSubTechnologyRequest getByIdSubTechnologyRequest);

    public List<GetSubTechnologyDetailsResponse> getAll();
}
