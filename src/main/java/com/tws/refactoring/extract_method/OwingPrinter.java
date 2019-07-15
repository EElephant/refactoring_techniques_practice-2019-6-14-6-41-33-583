package com.tws.refactoring.extract_method;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class OwingPrinter {
    private double outstanding = 0.0;
    void printOwing(String name, List<Order> orders) {
        Iterator<Order> elements = orders.iterator();

        printBanner();
        printOwings(elements);
        printDetails(name);

    }

    public void printBanner(){
        System.out.println ("*****************************");
        System.out.println ("****** Customer totals ******");
        System.out.println ("*****************************");
    }

    public void printOwings(Iterator<Order> elements){
        while (elements.hasNext()) {
            Order each = (Order) elements.next();
            this.outstanding += each.getAmount();
        }
    }

    public void printDetails(String name){
        System.out.println("name: " + name);
        System.out.println("amount: " + this.outstanding);
    }
}

class Order {
    private final double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
