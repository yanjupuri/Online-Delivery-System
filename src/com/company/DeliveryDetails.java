package com.company;

public class DeliveryDetails {
    private final String origin;
    private final String destination;
    private final String courier;
    private final String phoneNumber;
    private final int parcelNumber;
    private final int orderID;
    private final int deliveryId;
    private final double weight; //Weight of product
    private final double shippingCost; //1kg = 50pesos,2kg = 100pesos...

    public DeliveryDetails (String origin, String destination,int parcelNumber, int orderID, int deliveryId, String phoneNumber, double weight, double shippingCost, String courier){
        if (origin.equals(destination)){
            throw new IllegalArgumentException("Cannot deliver in the same address");
        }
        this.phoneNumber = phoneNumber;
        this.origin = origin;
        this.destination = destination;
        this.parcelNumber = parcelNumber;
        this.orderID = orderID;
        this.deliveryId = deliveryId;
        this.weight = weight;
        this.shippingCost = shippingCost;
        this.courier = courier;
    }


    public void display(){
        System.out.println("Phone number: " + getPhoneNumber());
        System.out.println("From " + getOrigin() + " to " + getDestination());
        System.out.println("Parcel number: " + getParcelNumber());
        System.out.println("Order ID: " + getOrderID());
        System.out.println("Delivery ID: " + getDeliveryId());
        System.out.println("Weight: " + getWeight() + "kg");
        System.out.println("Shipping cost: " + getShippingCost());
        System.out.println("Courier: " + getCourier());
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getOrigin() {
        return origin;
    }


    public String getDestination() {
        return destination;
    }


    public String getCourier() {
        return courier;
    }

    public int getParcelNumber() {
        return parcelNumber;
    }


    public int getOrderID() {
        return orderID;
    }



    public int getDeliveryId() {
        return deliveryId;
    }


    public double getWeight() {
        return weight;
    }


    public double getShippingCost() {
        return shippingCost;
    }
}
