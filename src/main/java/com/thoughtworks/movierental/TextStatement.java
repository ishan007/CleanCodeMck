package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

class TextStatement {

    private String name;
    private List<Rental> rentals;

    public TextStatement(String name, List<Rental> rentals){
        this.rentals = rentals;
        this.name = name;

    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + name + "\n";
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return result;
    }

    private String footer() {
        String result = "";
        result += "Amount owed is " + totalAmount() + "\n";
        result += "You earned " + totalFrequentRenterPoint()
                + " frequent renter points";
        return result;
    }

    private int totalFrequentRenterPoint() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenterPoint();
        }
        return frequentRenterPoints;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }
}
