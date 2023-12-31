package net.mh;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        String generatedfile="C:\\Temp\\Cart.json";

        Product p1= Product
                .builder()
                .id(1L)
                .description("mousse")
                .price(3.7)
                .quantity(6)
                .build();
        p1.setTotal();

        Product p2= new Product();
        p2.setId(2L);
        p2.setDescription("keyboard");
        p2.setPrice(14.9);
        p2.setQuantity(3);
        p2.setTotal();

        Product p3=  new Product(3L,"screen", 25.8,9);

        List<Product> productList=new ArrayList<>();
        Cart cart= Cart.builder()
                .productList(productList)
                .build();

        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);
        cart.addProduct(p2);
        cart.addProduct(p3);
        cart.addProduct(p1);
        cart.print();
        cart.generateJson(generatedfile);
    }
}
