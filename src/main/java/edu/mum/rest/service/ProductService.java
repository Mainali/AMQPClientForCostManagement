package edu.mum.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Product;
import edu.mum.rest.RestHttpHeader;


@Component
public class ProductService {
	@Autowired
	RestHttpHeader restHttpHeader;
	
	public Product write(Product product) {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		// HTTPEntity - SEND Headers & Body
		HttpEntity<Product> httpEntity = new HttpEntity<Product>(product, restHttpHeader.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/CostManagement/rest/products/addbill/", 
				    httpEntity, Product.class);
                                // Product.class - Response type
 		return null;
	}
	
}
