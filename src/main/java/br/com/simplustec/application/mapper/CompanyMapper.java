package br.com.simplustec.application.mapper;


import java.util.List;
import java.util.stream.Collectors;

import br.com.simplustec.application.datatransferobject.CompanyDTO;
import br.com.simplustec.application.domain.Company;

public class CompanyMapper {
	
	public static CompanyDTO makeCompanyDTO(Company company) {
		return CompanyDTO.builder()
					.id(company.getId())
					.name(company.getName())
					.build();
	}
	
    public static List<CompanyDTO> makeCompanyDTOList(List<Company> companies) {
        return companies.stream()
            .map(CompanyMapper::makeCompanyDTO)
            .collect(Collectors.toList());
    }	

}
