package com.salestax;

public class Tax {

	public double calculateTax(Product product) {
		return 0.0;
	}
	
	protected double roundTax(double tax) {
		return Math.ceil(tax*20.0)/20.0;
	}

	
}