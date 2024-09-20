package com.salestax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Tax basicTax = new BasicTax();
        Tax importDutyTax = new ImportDutyTax();
        TaxCalculator taxCalculator = new TaxCalculator(basicTax, importDutyTax);

        List<Product> products1 = new ArrayList<>();
        products1.add(new Product("1 book", 12.49, false, true));
        products1.add(new Product("1 music CD", 14.99, false, false));
        products1.add(new Product("1 chocolate bar", 0.85, false, true));
  
        List<Product> products2 = new ArrayList<>();
        products2.add(new Product("1 imported box of chocolates", 10.00, true, false));
        products2.add(new Product("1 imported bottle of perfume", 47.50, true, false));

        List<Product> products3 = new ArrayList<>();
        products3.add(new Product("1 imported bottle of perfume", 27.99, true, false));
        products3.add(new Product("1 bottle of perfume", 18.99, false, false));
        products3.add(new Product("1 packet of headache pills", 9.75, false, true));
        products3.add(new Product("1 box of imported chocolates", 11.25, true, false));

        System.out.println("Receipt 1:");
        Receipt receipt1 = new Receipt(products1, taxCalculator);
        receipt1.printReceipt();

        System.out.println("\nReceipt 2:");
        Receipt receipt2 = new Receipt(products2, taxCalculator);
        receipt2.printReceipt();

        System.out.println("\nReceipt 3:");
        Receipt receipt3 = new Receipt(products3, taxCalculator);
        receipt3.printReceipt();

        

        List<Product> products = new ArrayList<>();
        String moreProducts = "yes";

        while (moreProducts.equalsIgnoreCase("yes")) {
            System.out.println("Enter product name:");
            String name = scanner.nextLine();

            System.out.println("Enter product price:");
            double price = scanner.nextDouble();

            System.out.println("Is the product imported (true/false)?");
            boolean isImported = scanner.nextBoolean();

            System.out.println("Is the product tax-exempt (true/false)?");
            boolean isTaxExempt = scanner.nextBoolean();
            
            products.add(new Product(name, price, isImported, isTaxExempt));

            System.out.println("Do you want to add more products? (yes/no)");
            scanner.nextLine();
            moreProducts = scanner.nextLine();
        }

        Receipt receipt = new Receipt(products, taxCalculator);
        receipt.printReceipt();
    }
}