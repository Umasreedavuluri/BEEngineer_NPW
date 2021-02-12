package com.shopping.cart.model;

import java.util.List;

public class Order {
	private String id;
	private String name;
	private String description;
	private List<Item> items;
	private String status;
	private String date;
	
	public Order() {

	}

	public Order(String id, String name, String description, String date, List<Item> items) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.items = items;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}