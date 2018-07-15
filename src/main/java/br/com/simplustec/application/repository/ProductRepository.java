package br.com.simplustec.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.simplustec.application.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	public List<Product> findAll();
	
	@Query("select new br.com.simplustec.application.domain.Product(p.id, p.gtin, p.description, p.lastUpdate, p.company) from Product p where LENGTH(p.gtin) = ?#{[0]} and p.company.name like ?#{[1]}")
	public List<Product> findAllProductsByGtinSizeAndCompanyName(int gtinSize, String companyName);
	
}
