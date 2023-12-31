package net.mh;

import lombok.*;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class Product {
    private Long id;
    private String description;
    private Double price;
    private int quantity;
    private Double total;

    public Product(Long id, String description, Double price, int quantity) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        total=price*quantity;
    }

    public void setTotal() {
        total=price*quantity;
    }

    public void print()
    {
        System.out.printf( "%-10d %-20s %-20.2f %-15d %-20.2f %n", id, description,price,quantity,total);
    }
}
