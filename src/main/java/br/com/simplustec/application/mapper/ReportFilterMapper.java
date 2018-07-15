package br.com.simplustec.application.mapper;

import br.com.simplustec.application.datatransferobject.ReportFilterDTO;

public class ReportFilterMapper {
	
	public static ReportFilterDTO makeFilterDTO(String companyName, String productDescription, String gtin) {
		return	ReportFilterDTO.builder()
					.companyName(companyName)
					.productDescription(productDescription)
					.gtin(gtin)
					.build();
	}

}
