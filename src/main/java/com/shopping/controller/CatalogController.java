package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.model.Catalog;
import com.shopping.cart.service.CatalogService;


@RestController
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;

    @RequestMapping("/catalog/sku/{skuId}")
    public Catalog getSKU(@PathVariable String catalogId) {
    	return catalogService.retrieveCatalog(catalogId);
    }
    
}
