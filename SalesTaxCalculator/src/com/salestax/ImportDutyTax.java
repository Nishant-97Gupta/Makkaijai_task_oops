package com.salestax;

public class ImportDutyTax extends Tax {

	private static final double ImportDutyRate=0.05;
	
	@Override
	public double calculateTax(Product product) {
		if(!product.isImported()) {
			return 0.0;
		}
		
		double tax=product.getPrice()*ImportDutyRate;
		return roundTax(tax);
	}
	
}