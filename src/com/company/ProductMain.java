package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductMain {
    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
        productManagement.add(new Product("001", "IPhone 13", "New"));
        productManagement.add(new Product("002", "IPhone 12", "Like New"));
        productManagement.add(new Product("003", "IPhone 11", "Like New"));
        productManagement.add(new Product("004", "IPhone X", "Like New"));
        productManagement.add(new Product("005", "IPhone 8", "Old"));
//        productManagement.showList();
        String filePath = "product.doc";
        try {
            writeToFile(filePath, productManagement.getProducts());
        } catch (IOException e) {
            e.printStackTrace();
        }
        productManagement.add(new Product("006", "IPhone 7", "Old"));
        try {
            writeToFile(filePath, productManagement.getProducts());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            List<Product> products = readFile(filePath);
//            for (Product product:products){
//                System.out.println(product);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void writeToFile(String filePath, List<Product> products) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < products.size(); i++) {
            bufferedWriter.write(products.get(i).toString());
            if (i != products.size() - 1) {
                bufferedWriter.write("\n");
            }
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public static List<Product> readFile(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] columns = line.split(",");
            Product product = new Product(columns[0], columns[1], columns[2]);
            products.add(product);
        }
        return products;
    }
}
