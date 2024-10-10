package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StoreApp {

    public final static String dataFileName = "inventory.csv";
    public static ArrayList<Product> inventory = getInventory();

    public static void main(String[] args) {
        while (true) {
            try{
                System.out.println("What do you want to do?");
                System.out.println("1- List all products");
                System.out.println("2- Lookup a product by its id\n");
                System.out.println("3- Find all products within a price range\n");
                System.out.println("4- Add a new product\n");
                System.out.println("5- Quit the application\n");
                System.out.println("Enter command: ");

                byte selection = Console.PromptForByte();

                if (selection == 1) {
                    ListAllProducts();
                } else if (selection == 2) {
                    LookUpProductById();
                } else if (selection == 3) {
                    LookupProductsByPriceRange();
                } else if (selection ==4) {
                    AddNewProduct();
                } else if (selection == 5) {
                    return;
                }
                else {
                    System.out.println("Invalid command");
                }

            }catch(Exception e) {
                System.out.println("Invalid command");
            }
        }

    }

    public static void ListAllProducts(){
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }

    }

    public static void LookUpProductById(){

        try{
            short id = Console.PromptForShort("Enter a product ID: ");

            for(Product product: inventory) {
                if(product.getId() == id){
                    System.out.printf("id: %d %s - Price: $%.2f\n",
                            product.getId(), product.getName(), product.getPrice());
                    return;

                }
            }
            System.out.println("Product was not found");
        } catch (Exception e) {
            System.out.println("invalid Product ID, enter a numeric value less than 60,000");
        }

    }


    public static void LookupProductsByPriceRange(){
        double minPrice = Console.PromptForDouble("Min price= ");
        double maxPrice = Console.PromptForDouble("Max price= ");


        for (Product i : inventory){
            if(i.getPrice() >= minPrice && i.getPrice() <= maxPrice){
                System.out.printf("id: %d %s - Price: $%.2f\n",
                        i.getId(), i.getName(), i.getPrice());
                break;
            }
            else{
                System.out.println("No products available at this price range");
            }
        }

    }

    public static void AddNewProduct(){
        int productID = Console.PromptForInt("Please Enter an ID Number");
        String productName = Console.PromptForString("Please Enter the Product name: ");
        float productPrice = Console.PromptForFloat("Please Enter the Price: ");
        Product p = new Product(productID, productName, productPrice);
        inventory.add(p);
        saveInventory();

    }


    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        // this method loads product objects into inventory
        // and its details are not shown
        try{
            FileReader fr = new FileReader("inventory.csv");
            BufferedReader br = new BufferedReader(fr);

            String input;
            while((input = br.readLine()) != null) {
                String [] tokens = input.split(Pattern.quote("|"));
//                int productID = Integer.parseInt(tokens[0]);
//                String productName = tokens[1];
//                float productPrice = Float.parseFloat((tokens[2]));
//                Product p = new Product(productID, productName, productPrice);
//                inventory.add(p);

                //EVERYTHING ABOVE IN LINE
                inventory.add(new Product(Integer.parseInt(tokens[0]), tokens[1], Float.parseFloat((tokens[2]))));

            }

            br.close();


        } catch (Exception e) {
            System.out.println("Error!");
        }


        return inventory;
    }

    public static void saveInventory(){

        try{

            FileWriter fw = new FileWriter(dataFileName);

            for(Product p : inventory){
                String data = p.getId() + "|" + p.getName() + "|" + p.getPrice() + "\n";
                fw.write(data);
            }

            fw.close();
        } catch (Exception e) {
            System.out.println("FILE WRITE ERROR");
        }
    }
}
