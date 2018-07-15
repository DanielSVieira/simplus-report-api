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

import br.com.simplustec.application.datatransferobject.ProductDTO;
import br.com.simplustec.application.mapper.ProductMapper;
import br.com.simplustec.application.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> listProducts() {
		logger.trace("Executando requisição de todos produtos cadastrados");
		return new ResponseEntity<>(ProductMapper.makeProductDTOList(productService.findAll()), HttpStatus.OK);
	}

}
