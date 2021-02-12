package com.shopping.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.shopping.cart.model.Item;
import com.shopping.cart.model.Order;


@Component
public class OrderService {

	private static List<Order> orders = new ArrayList<>();

	static {
		//Initialize Data
		List<Item> items = new ArrayList<>();
		items.add(new Item("item1", "Tomato Sauce", "", "Order1"));
		items.add(new Item("item2", "Pepsi", "cool drink", "Order1"));
		Order order1 = new Order("Order1", "Pizza", "Pizza Delivery", "01/02/2021", items);

		items = new ArrayList<>();
		Order order2 = new Order("Order2", "Biryani", "Biryani Delivery", "01/02/2021" , items);
		
		items = new ArrayList<>();
		Order order3 = new Order("Order3", "BreakFast11", "Breakfast item Delivery", "01/02/2021", items);
		
		items = new ArrayList<>();
		Order order4 = new Order("Order4", "DinnerSpecial", "Dinner Delivery", "01/02/2021", items);
	
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
	}

	public List<Order> retrieveAllOrders() {
		return orders;
	}

	public Order retrieveOrder(String orderId) {
		for (Order order : orders) {
			if (order.getId().equals(orderId)) {
				return order;
			}
		}
		return null;
	}
	
	public Item retrieveItem(String orderId, String itemId) {
		for (Order order : orders) {
			if (order.getId().equals(orderId)) {
				for(Item item : order.getItems()) {
					if(item.getId().equals(itemId)) {
						return item;
					}
				}
			}
		}
		return null;
	}

	public Order addOrder(Order order) {
		orders.add(order);
		return order;
	}

	public Order cancelOrder(Order orderReq) {
		Order order = retrieveOrder(String.valueOf(orderReq.getId()));
		if (order == null) {
			return null;
		}
		order.setStatus("Cancel");
		return order;
	}
	
	public Item cancelItem(Item itemReq) {
		Item item = retrieveItem(itemReq.getOderId(), itemReq.getId());
		if (item == null) {
			return null;
		}else {
			for (Order order : orders) {
				if (order.getId().equals(itemReq.getOderId())) {
					for(Item itemToBeCancel : order.getItems()) {
						if(itemToBeCancel.getId().equals(itemReq.getId())) {
							itemToBeCancel.setStatus("Cancel");
							return itemToBeCancel;
						}
					}
				}
			}

		}
		return null;
	}

	public Order updateOrder(Order orderReq) {
		for (Order order : orders) {
			if (order.getId().equals(orderReq.getId())) {
				order.setDate(orderReq.getDate());
				return order;
			}
		}
		return null;
	}
	
}