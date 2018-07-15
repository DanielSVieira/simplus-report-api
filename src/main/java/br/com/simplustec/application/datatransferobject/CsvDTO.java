package br.com.simplustec.application.datatransferobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class CsvDTO {
	
	private String fileName;
	private String csvContent;

}
