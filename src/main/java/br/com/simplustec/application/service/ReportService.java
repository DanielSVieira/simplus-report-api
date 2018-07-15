package br.com.simplustec.application.service;

import org.springframework.core.io.Resource;

import br.com.simplustec.application.datatransferobject.ReportFilterDTO;

public interface ReportService {
	
	public Resource generateDefaultReport(); 
	public byte[] generateDefaultReportInMemory();
	public byte[] generateReportInMemory(ReportFilterDTO reportFilterDTO);
}
