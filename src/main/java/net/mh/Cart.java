package net.mh;

import com.google.gson.Gson;
import lombok.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class Cart {
    private List<Product> productList;

    public boolean addProduct(Product product) {

        if(productList.contains(product)) return false;
        productList.add(product);
        return true;
    }

    public Double total()
    {
        return productList.stream()
                .mapToDouble(Product::getTotal)
                .sum();
    }
    public void print()
    {
        System.out.printf( "%-10s %-20s %-20s %-15s %-20s %n", "id", "description","price","quantity","total");
        System.out.println("---------------------------------------------------------------------------");
        productList.forEach(Product::print);
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf( "%-68s %-20.2f %n", "Total", total());
    }

    public void generateJson(String filename)
    {
        Gson gson = new Gson();

        try {
            FileWriter fileWriter=new FileWriter(filename);
            gson.toJson(productList, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
