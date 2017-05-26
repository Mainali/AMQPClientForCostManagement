package edu.mum.rest.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.ItemBought;
import edu.mum.domain.Product;
import edu.mum.rest.RestHttpHeader;

@Component
public class ItemBoughtService {
	
	@Autowired
	RestHttpHeader restHttpHeader;
	
	public void processBill(String fileName){
		
		try {
            FileReader fr = new FileReader("d:/uploads/"+fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            
            ItemBought itemBoughtByUser = new ItemBought();
            int price = 0;
            List<Product> productList = new ArrayList<>();
            Product product;

            while((line=reader.readLine())!=null) {
            	String tag = line.substring(0, line.lastIndexOf("=")).trim();
            	String value = line.substring(line.lastIndexOf("=")+1).trim();
            	product = new Product();
            	switch(tag) {
            	case "group":
            		itemBoughtByUser.setExpGroupName(value);
            		break;
            	case "boughtby":
            		itemBoughtByUser.setBoughtBy(value);
            		break;
            	case "datetime":
            		itemBoughtByUser.setDate(value);
            		break;
            	case "itemname":
            		product.setName(value);
            		break;
            	case "price":
            		int priceOfItem = Integer.parseInt(value.toString());
            		price += priceOfItem;
            		product.setPrice((float) priceOfItem);
            		productList.add(product);
            		break;
            		
            	}
            	itemBoughtByUser.setPrice(price);
            	itemBoughtByUser.setItemsBought(productList);
            }
            
            if(restHttpHeader == null) {
            	restHttpHeader = new RestHttpHeader();
            }
            RestTemplate restTemplate = restHttpHeader.getRestTemplate();
    		// HTTPEntity - SEND Headers & Body
    		HttpEntity<ItemBought> httpEntity = new HttpEntity<ItemBought>(itemBoughtByUser , restHttpHeader.getHttpHeaders());
    		restTemplate.postForObject("http://localhost:8080/CostManagement/rest/products/addbill/", 
    				    httpEntity, ItemBought.class);
    		System.out.println("File Processed Successfully");
    		System.out.println("status: "+ httpEntity.getHeaders().toString());
        }catch(IOException ex) {
            ex.printStackTrace();
        }
	}
	

}
