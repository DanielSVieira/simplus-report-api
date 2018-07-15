package br.com.simplustec.application.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.simplustec.application.datatransferobject.ProductDTO;
import br.com.simplustec.application.domain.Company;
import br.com.simplustec.application.domain.Product;

public class ProductMapperTest {
	
	private Company company1;
	
	@Before
	public void init() {
		this.company1 = new Company(1L, "nome 1");
	}
	
	@Test
	public void createDTOSucess() {
		Product product = new Product(1L, "7891000200001", "Sabonete", new Date(), company1);
		ProductDTO productDTO = ProductMapper.makeProductDTO(product);
		assertEquals(product.getDescription(), productDTO.getDescription());
		assertEquals(product.getGtin(), productDTO.getGtin());
		assertEquals(company1.getName(), productDTO.getCompanyName());
	}
	
	

}
