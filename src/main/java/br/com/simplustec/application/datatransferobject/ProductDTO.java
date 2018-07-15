package br.com.simplustec.application.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
	private Long id;
	private String gtin;
	private String description;
	private String lastUpdate;
	private String companyName;
}
