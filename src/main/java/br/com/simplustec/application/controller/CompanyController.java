package br.com.simplustec.application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.simplustec.application.datatransferobject.CompanyDTO;
import br.com.simplustec.application.mapper.CompanyMapper;
import br.com.simplustec.application.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<CompanyDTO>> listCompanies() {
		logger.trace("Executando requisição de todas empresas cadastradas");
		return new ResponseEntity<>(CompanyMapper.makeCompanyDTOList(companyService.findAll()), HttpStatus.OK);
	}
}
