package Test;
import org.junit.jupiter.api.Test;

import com.salestax.BasicTax;
import com.salestax.ImportDutyTax;
import com.salestax.Product;
import com.salestax.Tax;
import com.salestax.TaxCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxCalculatorTest {

    @Test
    void testBasicTaxCalculation() {
        Tax basicTax = new BasicTax();
        Tax importDutyTax = new ImportDutyTax();
        TaxCalculator taxCalculator = new TaxCalculator(basicTax, importDutyTax);

        Product product = new Product("music CD", 14.99, false, false);
        double tax = taxCalculator.calculateTotalTax(product);
        assertEquals(1.50, tax, 0.01);  // Asserting the basic tax
    }

    @Test
    void testImportDutyTaxCalculation() {
        Tax basicTax = new BasicTax();
        Tax importDutyTax = new ImportDutyTax();
        TaxCalculator taxCalculator = new TaxCalculator(basicTax, importDutyTax);

        Product importedProduct = new Product("imported chocolates", 10.00, true, true);
        double tax = taxCalculator.calculateTotalTax(importedProduct);

        assertEquals(0.50, tax, 0.01);  // Asserting the import duty tax
    }
}


