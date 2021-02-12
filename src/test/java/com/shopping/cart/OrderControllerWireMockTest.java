package com.shopping.cart;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.shopping.controller.OrderController;

public class OrderControllerWireMockTest {

    private OrderController controller;
    private static final String APPLICATION_JSON = "application/json";
    @Before
    public void setUp() {
        controller = new OrderController();
    }

    @Rule public WireMockRule wireMockRule = new WireMockRule(8089);
    
    @Test
    public void testgetOrderById() {
    	stubFor(get(urlPathMatching("/order/Order1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", APPLICATION_JSON)));

    }
    
    @Test
    public void testAcceptShipDate() {
    	stubFor(post(urlEqualTo("/orderactions/acceptShipDate"))
                .withHeader("Content-Type", equalTo(APPLICATION_JSON))
                .withRequestBody(containing("\"id\": \"Order1\""))
                .withRequestBody(containing("\"date\": \"10/02/2021\""))
                .willReturn(aResponse().withStatus(200)));
    }
    
    @Test
    public void testCancelItem() {
    	stubFor(post(urlEqualTo("/orderactions/cancelItem"))
                .withHeader("Content-Type", equalTo(APPLICATION_JSON))
                .withRequestBody(containing("\"id\": \"item1\""))
                .withRequestBody(containing("\"status\": \"cancel\""))
                .willReturn(aResponse().withStatus(200)));
    }
    
    @Test
    public void testCancelOrder() {
    	stubFor(post(urlEqualTo("/orderactions/cancelItem"))
                .withHeader("Content-Type", equalTo(APPLICATION_JSON))
                .withRequestBody(containing("\"orderId\": \"Order1\""))
                .withRequestBody(containing("\"status\": \"cancel\""))
                .willReturn(aResponse().withStatus(200)));
    }
}
