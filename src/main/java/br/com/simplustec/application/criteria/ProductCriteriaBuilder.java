package br.com.simplustec.application.criteria;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.simplustec.application.datatransferobject.ReportFilterDTO;
import br.com.simplustec.application.domain.Product;


public class ProductCriteriaBuilder {
	
	public static TypedQuery<Product> createQuery(ReportFilterDTO reportFilterDTO , EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Product> query = builder.createQuery(Product.class);
		Root<Product> from = query.from(Product.class);
		
		Predicate predicate = builder.and();
		
		if(reportFilterDTO.getGtin() != null) {
		    predicate = builder.and(predicate, 
		    		builder.like(from.<String>get("gtin"), reportFilterDTO.getGtin()));
		}
		
		if(reportFilterDTO.getProductDescription() != null) {
		    predicate = builder.and(predicate, 
		    		builder.like(from.<String>get("description"), reportFilterDTO.getProductDescription()));
		}
		
	    TypedQuery<Product> typedQuery = em.createQuery(
	    	    query.select(from )
	    	    .where( predicate )
	    );
	    
		return typedQuery;
	}
}
