package com.shopping.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.shopping.cart.model.Catalog;


@Component
public class CatalogService {

	private static List<Catalog> catalogs = new ArrayList<>();

	static {
		//Initialize Data
		Catalog catalog1 = new Catalog("Catalog1", "Mobile Catalog", "Mobile Delivery");
		
		Catalog catalog2 = new Catalog("Catalog2", "Vegetable Catalog", "Vegetble Delivery");
		
		Catalog catalog3 = new Catalog("Catalog3", "Fruits Catalog", "Fruits Delivery");
		
		Catalog catalog4 = new Catalog("Catalog4", "Home Appliance Catalog", "Home Appliance Delivery");
	
		catalogs.add(catalog1);
		catalogs.add(catalog2);
		catalogs.add(catalog3);
		catalogs.add(catalog4);
	}

	public List<Catalog> retrieveAllCatalogs() {
		return catalogs;
	}

	public Catalog retrieveCatalog(String catalogId) {
		for (Catalog catalog : catalogs) {
			if (catalog.getId().equals(catalogId)) {
				return catalog;
			}
		}
		return null;
	}

	public Catalog addCatalog(Catalog catalog) {
		catalogs.add(catalog);
		return catalog;
	}

	public Catalog updateCatalog(String catalogId, Catalog catalogReq) {
		Catalog catalog = retrieveCatalog(String.valueOf(catalogId));
		if (catalog == null) {
			return null;
		}
		catalog.setName(catalogReq.getName());
		catalog.setDescription(catalogReq.getDescription());
		return catalog;
	}
}