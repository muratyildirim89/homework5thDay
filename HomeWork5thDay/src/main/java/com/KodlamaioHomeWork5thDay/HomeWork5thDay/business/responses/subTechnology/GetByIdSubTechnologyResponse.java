package com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdSubTechnologyResponse {
    private int id;
    private String name;
    private int programmingLanguageId;
}
