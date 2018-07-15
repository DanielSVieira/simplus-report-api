package br.com.simplustec.application.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.simplustec.application.constants.ReportNamesConstants;
import br.com.simplustec.application.datatransferobject.ReportFilterDTO;
import br.com.simplustec.application.mapper.ReportFilterMapper;
import br.com.simplustec.application.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(value = "/createDefaultReport", method = RequestMethod.GET)
	public ResponseEntity<Resource>  downloadReport() throws Exception {
		logger.trace("Executando relatório com escrita de arquivo temporário em disco");
		Resource resource = reportService.generateDefaultReport();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
	}
	
	@RequestMapping(value = "/createDefaultReportInMemory", method = RequestMethod.GET)
	public byte[]  downloadDefaultReportInMemory(HttpServletResponse response) throws Exception {
		logger.trace("Executando relatório com arquivo zipado inteiramente em memória");
		byte[] zippedReport = reportService.generateDefaultReportInMemory();
		
		response.setHeader("Content-Disposition", "attachment; filename=" + ReportNamesConstants.ZIPPED_REPORTS);
		return zippedReport;
	}
	
	@RequestMapping(value = "/createReportInMemory", method = RequestMethod.GET)
	public byte[]  downloadReportInMemory(HttpServletResponse response, 
			@RequestParam(required = false) String companyName,
			@RequestParam(required = false) String productDescription,
			@RequestParam(required = false) String gtin
			) throws Exception {
		logger.trace("Executando relatório com arquivo zipado inteiramente em memória com filtros");
		ReportFilterDTO reportFilterDTO = ReportFilterMapper.makeFilterDTO(companyName, productDescription, gtin);
		byte[] zippedReport = reportService.generateReportInMemory(reportFilterDTO);
		
		response.setHeader("Content-Disposition", "attachment; filename=" + ReportNamesConstants.ZIPPED_REPORTS);
		return zippedReport;
	}
	
}
