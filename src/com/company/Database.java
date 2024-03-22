package com.company;

import java.io.*;
import java.util.*;

public class Database {
    public void saveCustomer(WebUser webUser){

        try{
            Customer customer = (Customer) webUser;
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new FileWriter("list-of-customer.txt", true));

            bufferedWriter.write("Name:\t " + customer.getCustomerName() + "\n");
            bufferedWriter.write("Password:\t " + customer.getPassword() + "\n");
            bufferedWriter.write("ID:\t " + customer.getCustomerId() + "\n");
            bufferedWriter.write("Date created:\t " + customer.getRegisterDate() + "\n");
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }

    }

    public void saveDeliveryDetails(DeliveryDetails deliveryDetails, String user){
        try{
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new FileWriter("list-of-deliveryDetails.txt", true));

            bufferedWriter.write("Recipient:\t " + user + "\n");
            bufferedWriter.write("Contact number:\t " + deliveryDetails.getPhoneNumber() + "\n");
            bufferedWriter.write("From:\t " + deliveryDetails.getOrigin() + "\n");
            bufferedWriter.write("To:\t " + deliveryDetails.getDestination() + "\n");
            bufferedWriter.write("Parcel number:\t " + deliveryDetails.getParcelNumber() + "\n");
            bufferedWriter.write("Order ID:\t " + deliveryDetails.getOrderID() + "\n");
            bufferedWriter.write("Delivery ID:\t " + deliveryDetails.getDeliveryId() + "\n");
            bufferedWriter.write("Weight:\t " + deliveryDetails.getWeight() + "kg\n");
            bufferedWriter.write("Shipping cost:\t " + deliveryDetails.getShippingCost() + "\n");
            bufferedWriter.write("Courier:\t " + deliveryDetails.getCourier() + "\n");
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }
    }

    public void displayDetails(){
        try{
            BufferedReader bufferedReader
                    = new BufferedReader(new FileReader("list-of-deliveryDetails.txt"));

            String line;
            List<String> fileContent = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null){
                fileContent.add(line);
            }
            if (!fileContent.isEmpty()) {
                System.out.println("\n────────────[ Display ]────────────\n");
                for (String element : fileContent) {
                    System.out.println(element);
                }
            }else {
                System.out.println("Congrats! No queue delivery");
            }
        }catch (Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }
    }

    public void modifyFile(String oldString, String newString){
        File tobeModified = new File("list-of-deliveryDetails.txt");
        String oldContent = "";
        BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(tobeModified));
            String line = bufferedReader.readLine();

            while (line != null){
                oldContent = oldContent + line + System.lineSeparator();
                line = bufferedReader.readLine();
            }

            String newContent  = oldContent.replaceAll(oldString, newString);

            fileWriter = new FileWriter(tobeModified);
            fileWriter.write(newContent);

            bufferedReader.close();
            fileWriter.close();
        }catch (Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }
    }

}
