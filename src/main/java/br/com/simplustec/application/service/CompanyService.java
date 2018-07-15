package br.com.simplustec.application.service;

import java.util.List;

import br.com.simplustec.application.domain.Company;

public interface CompanyService {
	
	public List<Company> findAll();
	public List<Company> findAllByCompanyNameLike(String companyName);

}
