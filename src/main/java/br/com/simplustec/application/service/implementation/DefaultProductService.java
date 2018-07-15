package br.com.simplustec.application.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simplustec.application.domain.Product;
import br.com.simplustec.application.repository.ProductRepository;
import br.com.simplustec.application.service.ProductService;

@Service
public class DefaultProductService implements ProductService {
	
	private final int PRODUCT_GTIN_LENGTH = 13;
	private final int BOX_GTIN_LENGTH = 14;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Override
	public List<Product> findAllProductsWithoutBoxes(String companyName) {
		return productRepository.findAllProductsByGtinSizeAndCompanyName(PRODUCT_GTIN_LENGTH, companyName);
	}

	@Override
	public List<Product> findAllProductsBoxes(String companyName) {
		return productRepository.findAllProductsByGtinSizeAndCompanyName(BOX_GTIN_LENGTH, companyName);
	}

}
