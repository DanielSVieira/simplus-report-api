package br.com.simplustec.application.mapper;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;


import br.com.simplustec.application.datatransferobject.ProductDTO;
import br.com.simplustec.application.domain.Product;
import br.com.simplustec.application.exception.InvalidDateFormatException;
import br.com.simplustec.application.utils.DateUtils;

public class ProductMapper {
	
	public static ProductDTO makeProductDTO(Product product) {
		try {
			return ProductDTO.builder()
					.id(product.getId())
					.description(product.getDescription())
					.gtin(product.getGtin())
					.lastUpdate(DateUtils.getDateWithoutTime(product.getLastUpdate()))
					.companyName(product.getCompany().getName())
					.build();
		} catch (ParseException e) {
			throw new InvalidDateFormatException("Não foi possível formatar a data da última atualização do produto de ID " + product.getId());
		}
	}
	
    public static List<ProductDTO> makeProductDTOList(List<Product> products) {
        return products.stream()
            .map(ProductMapper::makeProductDTO)
            .collect(Collectors.toList());
    }
    
}
