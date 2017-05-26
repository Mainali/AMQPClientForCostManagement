package edu.mum.domain;


import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class ItemBought {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long price;

	private String date;

	private String boughtBy;

	private String expGroupName;

	public List<Product> getItemsBought() {
		return itemsBought;
	}

	public void setItemsBought(List<Product> itemsBought) {
		this.itemsBought = itemsBought;
	}

	private List<Product> itemsBought;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getBoughtBy() {
		return boughtBy;
	}

	public void setBoughtBy(String boughtBy) {
		this.boughtBy = boughtBy;
	}

	public String getExpGroupName() {
		return expGroupName;
	}

	public void setExpGroupName(String expGroupName) {
		this.expGroupName = expGroupName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
