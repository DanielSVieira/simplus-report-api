package br.com.simplustec.application.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simplustec.application.domain.Company;
import br.com.simplustec.application.repository.CompanyRepository;
import br.com.simplustec.application.service.CompanyService;

@Service
public class DefaultCompanyService implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	public List<Company> findAllByCompanyNameLike(String companyName) {
		if(companyName == null) {
			return companyRepository.findAll();
		}
		return companyRepository.findAllByNameContaining(companyName);
	}

}
