package net.mh;

import junit.framework.TestCase;

public class ProductTest extends TestCase {

    public void testGetTotal() {
        Product product=new Product(1L,"Hard disk", 13.0,2);
        assertEquals("The total has not been correctly calculated",product.getTotal(),26.0);
    }
}