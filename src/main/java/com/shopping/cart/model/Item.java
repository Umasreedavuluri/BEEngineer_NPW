package com.shopping.cart.model;

public class Item {
	private String id;
	private String name;
	private String description;
	private String Status;
	private String oderId;
	
	public String getOderId() {
		return oderId;
	}

	public void setOderId(String oderId) {
		this.oderId = oderId;
	}

	public Item() {

	}

	public Item(String id, String name, String description, String orderId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.oderId = orderId;
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

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}


}
