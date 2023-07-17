package model;

import java.util.Map;

public class Cart {
	Map<Product,Integer> cart;
	Cart(String user){
		cart = null;
	}
	void insertProduct(Product p){
		cart.put(p, 1);
	}
	void updateQuantity(Product p,int i) {
		cart.put(p, i);
	}
}
