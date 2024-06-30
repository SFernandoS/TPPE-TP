import Sale.Sale;
import Sale.SaleService;
import customer.Customer;
import customer.CustomerType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import product.Product;

import java.util.Date;
import java.time.Instant;
import java.util.ArrayList;


// cadastrar venda
// calcular frete
// calcular descontos
// calcular impostos
// calcular cashback

@RunWith(Parameterized.class)
public class SaleServiceTest {

    SaleService saleService;
    Object[] sales;

    Object sale;


    public SaleServiceTest(Object[] sales, Object sale) {
        this.sales = sales;
        this.sale = sale;
    }

    @Before
    public void setup() {
        saleService = new SaleService();
    }


    @Parameters
    public static Object[][] getParameters() {
        ArrayList<Product> productsA = new ArrayList<>();
        productsA.add(new Product(1, "Bicicleta",300,"unidade"));
        Customer customerA = new Customer("Juliana", CustomerType.STANDARD, "Valparaiso",false);
        Sale saleA = new Sale(Date.from(Instant.now()), customerA, productsA, "0234567890123456");

        ArrayList<Product> productsB = new ArrayList<>();
        productsB.add(new Product(2,"Camisa",50,"unidade"));
        Customer customerB = new Customer("Adriano", CustomerType.STANDARD, "Gama",false);
        Sale saleB = new Sale(Date.from(Instant.now()), customerB, productsB, "0234567890123456");

        ArrayList<Product> productsC = new ArrayList<>();
        productsB.add(new Product(2,"Camisa",50,"unidade"));
        Customer customerC = new Customer("Adriano", CustomerType.STANDARD, "Gama",false);
        Sale saleC = new Sale(Date.from(Instant.now()), customerC, productsC, "0234567890123456");
        return new Object[][] {
                {
                    new Object[] {saleA},
                        saleA
                },
                {
                    new Object[] {saleA,saleB},
                        saleB
                },
                {
                    new Object[] {saleA, saleB, saleC},
                        saleC
                }
        };

    }

    @Test
    public void testAddSale() {
        for(Object sale : sales) {
            saleService.addSale((Sale) sale);
        }

        Assert.assertTrue(saleService.getSales().contains(sale));
    }





}
