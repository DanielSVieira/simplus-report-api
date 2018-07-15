package br.com.simplustec.application.service;

import java.util.List;

import br.com.simplustec.application.domain.Product;

public interface ProductService {
	
	public List<Product> findAll();
	public List<Product> findAllProductsWithoutBoxes(String companyName);
	public List<Product> findAllProductsBoxes(String companyName);

}
