package com.company;

import java.io.*;
import java.text.*;
import java.util.*;

public class OLDelivery {

    public static void placeOrder(String username){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Database access = new Database();
        Random random = new Random();
        int parcelNumber, orderId, deliveryId;
        String destination, origin, courier = "";
        double weight, shippingCost = 0.0, fee = 0.0;

        System.out.println("\n────────────[ Placing Order ]────────────\n");
        System.out.print("Enter weight of product(kg): ");
        weight = scanner.nextDouble();
        if (weight <= 50){
            System.out.print("Enter origin place: ");
            origin = scanner1.nextLine();
            System.out.print("Enter destination place: ");
            destination = scanner2.nextLine();

            parcelNumber = random.nextInt(1000) + 10;
            orderId = random.nextInt(500) + 4;
            deliveryId = random.nextInt(300) + 37;

            if (weight >=1 && weight <=5){
                shippingCost = weight * 20;
            }else if (weight >= 6 && weight <= 10){
                shippingCost = weight * 30;
            }else if (weight >= 11 && weight <= 15){
                shippingCost = weight * 40;
            }else if (weight >= 16 && weight <= 20){
                shippingCost = weight * 50;
            }else if (weight >= 21 && weight <= 30){
                shippingCost = weight * 60;
            }else if (weight >= 31 && weight <= 40){
                shippingCost = weight * 75;
            }else if (weight >= 41 && weight <= 50){
                shippingCost = weight * 100;
            }

            boolean valid = false;
            while (!valid) {
                System.out.println("\n────────────[ Courier ]────────────\n");
                System.out.println("[1] J&T Express");
                System.out.println("[2] LBC");
                System.out.println("[3] Ninja Van");
                System.out.println("[4] Gogo Express");
                System.out.println("[5] Entrego");
                System.out.println("[6] JRS");
                System.out.println("[7] XDE");
                System.out.print("Enter choice: ");
                int choice = scanner1.nextInt();

                if (choice == 1) {
                    valid = true;
                    courier = "J&T Express";
                    fee = shippingCost - ((shippingCost * 10) / 100);
                } else if (choice == 2) {
                    valid = true;
                    courier = "LBC";
                    fee = shippingCost - ((shippingCost * 15) / 100);
                } else if (choice == 3) {
                    valid = true;
                    courier = "Ninja Van";
                    fee = shippingCost - ((shippingCost * 10) / 100);
                } else if (choice == 4) {
                    valid = true;
                    courier = "Gogo Express";
                    fee = shippingCost - ((shippingCost * 14) / 100);
                } else if (choice == 5) {
                    valid = true;
                    courier = "Entrego";
                    fee = shippingCost - ((shippingCost * 12) / 100);
                } else if (choice == 6) {
                    valid = true;
                    courier = "JRS";
                    fee = shippingCost - ((shippingCost * 18) / 100);
                } else if (choice == 7) {
                    valid = true;
                    courier = "XDE";
                    fee = shippingCost - ((shippingCost * 15) / 100);
                }else {
                    System.out.println("Please choose a courier!");
                }
            }
            System.out.println("\n────────────[ Contact Number ]────────────\n");
            System.out.print("Enter phone number: ");
            String phoneNumber = scanner2.nextLine();

            DeliveryDetails details = new DeliveryDetails(origin, destination, parcelNumber, orderId, deliveryId, phoneNumber, weight, fee, courier);
            access.saveDeliveryDetails(details, username);
            System.out.println("\n────────────[ Details ]────────────\n");
            System.out.println("Recipient: " + username);
            details.display();
        }else{
            System.out.println("We do not deliver with a weight exceeding 50kg");
        }

    }

    public static void createCustomer(){
        Database access = new Database();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        String password, username;
        int customerId;
        String again;
        do {
            System.out.println("\n────────────[ Sign Up ]────────────\n");
            System.out.print("Enter name: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner1.nextLine();
            Random random = new Random();
            customerId = random.nextInt(100) + 5;

            System.out.println("\n────────────[ Confirmation of Account ]────────────\n");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Press Y if the above information is correct, otherwise press N.");
            again = scanner2.nextLine();

        }while (again.equalsIgnoreCase("N"));

        format.format(date);
        System.out.println("\n────────────[ Account Information ]────────────\n");
        Customer customer = new Customer(username, customerId, password, date);
        customer.displayInformation();
        access.saveCustomer(customer);

    }

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Database access = new Database();
        int choice;
        boolean flag = false;

        try {
            while (!flag){
                System.out.println("\n───────────────[ M E N U ]───────────────\n");
                System.out.println("[1] Create new account"); // Create new customer account
                System.out.println("[2] Login account"); // For existing account
                System.out.println("[3] Admin option"); // Admin or the owner option
                System.out.println("[4] Terminate the program"); // End the program
                System.out.print("Enter option: ");
                choice = scanner1.nextInt();

                // switch statement for options
                switch (choice){
                    case 1:
                        //Register customer account
                        createCustomer();
                        break;
                    case 2:
                        //Login customer
                        //Existing customer
                        //Place order
                        System.out.println("────────────[ Login ]────────────\n");
                        System.out.print("Enter name: ");
                        String username = scanner2.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner2.nextLine();

                        try{

                            BufferedReader bufferedReader = new BufferedReader(new FileReader("list-of-customer.txt"));

                            String line;
                            List<String> fileContent = new ArrayList<>();

                            while ((line = bufferedReader.readLine()) != null){
                                fileContent.add(line);
                            }

                            String element = fileContent.toString();

                            if (element.contains(username) && element.contains(password)){
                                placeOrder(username);
                            }else {
                                System.out.println("Invalid account");
                            }
                        }catch (Exception exception){
                            System.out.println("Exception: " + exception.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("\n────────────[ Admin Login ]────────────\n");
                        System.out.print("Enter admin name: ");
                        String admin = scanner2.nextLine();
                        System.out.print("Enter admin password: ");
                        String adminPassword = scanner2.nextLine();

                        // Admin username and password
                        if (admin.equals("jra") && adminPassword.equals("jyz")){
                            boolean valid = false;

                            while (!valid) {
                                System.out.println("\n────────────[ Admin Screening ]────────────\n");
                                System.out.println("[1] Display queued transaction");
                                System.out.println("[2] Completed parcel");
                                System.out.println("[3] Leave");
                                System.out.print("Enter option: ");
                                int option = scanner1.nextInt();

                                if (option == 1) {
                                    //Get all the queued delivery
                                    //List of all delivery details
                                    access.displayDetails();
                                } else if (option == 3) {
                                    //Leave from admin screen
                                    valid = true;
                                }else if (option == 2){
                                    //Modify
                                    System.out.print("Enter parcel number: ");
                                    String parcelNumber = scanner2.nextLine();

                                    System.out.println("Parcel number " + parcelNumber + " has been set to done");
                                    access.modifyFile(parcelNumber, "Item received");
                                }else {
                                    System.out.println("Invalid option!");
                                }
                            }
                        }else {
                            System.out.println("Incorrect admin account");
                        }

                        break;
                    case 4:
                        //Terminating the program
                        flag = true;
                        System.out.println("Exiting...\n5\n4\n3\n2\n1");
                        break;
                    default:
                        System.out.println("Please enter a valid choice");
                        break;
                }
            }
        }catch (Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
