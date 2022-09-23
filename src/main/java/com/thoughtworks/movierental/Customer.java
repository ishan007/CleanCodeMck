package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            double amount = rental.amount();
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    amount + "\n";
        }

        //add footer lines result
        result += "Amount owed is " + totalAmount() + "\n";
        result += "You earned " + totalFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }


    public String htmlStatement(){
        String result = "<html>\n" +
                "<header>Rental Record for " + name +
                "</header>\n<body>";
        for (Rental rental : rentals) {
            double amount = rental.amount();
            //show figures for this rental
            result += rental.getMovie().getTitle() + "\t" + amount + "\n";
        }
        result += "</body>\n" +
                "<footer>\n" +
                "<p>Amount owed is " + totalAmount() +
                "</p>\n" +
                "<p>You earned " + totalFrequentRenterPoints() +
                " frequent renter points</p>\n" +
                "</footer>\n" +
                "</html>";
        return result;
    }


    private double totalAmount(){
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

    private int totalFrequentRenterPoints(){
        int totalFrequentRenterPoints = 0;
        for (Rental rental : rentals) {
            totalFrequentRenterPoints += rental.frequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }


}
