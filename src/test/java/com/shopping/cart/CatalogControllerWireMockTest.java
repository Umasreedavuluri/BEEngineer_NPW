package com.shopping.cart;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.shopping.controller.CatalogController;

public class CatalogControllerWireMockTest {

	private CatalogController controller;
	private static final String APPLICATION_JSON = "application/json";

	@Before
	public void setUp() {
		controller = new CatalogController();
	}

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089);

	@Test
	public void testGetCatalogById() {
		stubFor(get(urlPathMatching("//catalog/sku/Catalog1"))
				.willReturn(aResponse().withStatus(200).withHeader("Content-Type", APPLICATION_JSON)));

	}
}
