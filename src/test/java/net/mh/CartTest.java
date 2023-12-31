package net.mh;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class CartTest extends TestCase {

    public void testAddProduct() {
        List<Product> list=new ArrayList<>();
        Product product=new Product(1L,"Hard disk", 13.0,2);
        Cart cart=new Cart(list);
        assertTrue("Product not added to cart",cart.addProduct(product));
        assertFalse("Duplicate product not authorized in the card",cart.addProduct(product));
    }

    public void testTotal() {
        List<Product> list=new ArrayList<>();
        Product product1=new Product(1L,"Hard disk", 13.0,2);
        Product product2=new Product(2L,"Screen", 10.0,5);
        Cart cart=new Cart(list);
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertEquals("The total amount is not correct",cart.total(),76.0);
    }
}