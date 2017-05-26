package edu.mum.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.rest.service.ItemBoughtService;

@Component
public class ProductListener {
	
	@Autowired
	ItemBoughtService itemBoughtService;
	
	private void listen(String fileName){
		System.out.println("File Consumed");
		System.out.println("File to process: "+ fileName);
		System.out.println();
		if(itemBoughtService == null) {
			itemBoughtService = new ItemBoughtService();
		}
		itemBoughtService.processBill(fileName);
		
	}
}
