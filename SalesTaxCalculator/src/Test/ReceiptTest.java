package Test;

import org.junit.jupiter.api.Test;

import com.salestax.BasicTax;
import com.salestax.ImportDutyTax;
import com.salestax.Product;
import com.salestax.Receipt;
import com.salestax.Tax;
import com.salestax.TaxCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

class ReceiptTest {

    @Test
    void testReceiptTotalPrice() {
        Tax basicTax = new BasicTax();
        Tax importDutyTax = new ImportDutyTax();
        TaxCalculator taxCalculator = new TaxCalculator(basicTax, importDutyTax);

        Product product1 = new Product("book", 12.49, false, true);
        Product product2 = new Product("music CD", 14.99, false, false);
        List<Product> products = Arrays.asList(product1, product2);

        Receipt receipt = new Receipt(products, taxCalculator);
        double expectedTotalPrice = 12.49 + 14.99 + 1.50; // Basic tax on music CD
        
    }
}
