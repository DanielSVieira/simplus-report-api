package br.com.simplustec.application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.simplustec.application.domain.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	public List<Company> findAll();
	public List<Company> findAllByNameContaining(String companyName);

}
