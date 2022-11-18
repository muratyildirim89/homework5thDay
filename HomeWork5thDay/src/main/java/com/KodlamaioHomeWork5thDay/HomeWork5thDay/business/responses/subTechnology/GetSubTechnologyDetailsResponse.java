package com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.subTechnology;

import com.KodlamaioHomeWork5thDay.HomeWork5thDay.business.responses.programmingLanguage.GetProgrammingLanguageDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetSubTechnologyDetailsResponse {
	private int id;
	private String name;
	private GetProgrammingLanguageDetailsResponse technology;
}
