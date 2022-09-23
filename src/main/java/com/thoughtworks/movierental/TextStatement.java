package com.thoughtworks.movierental;

import java.util.List;

class TextStatement {

    private String name;
    private double totalAmount;
    private int totalFrequentRenterPoint;
    private List<Rental> rentals;

    public TextStatement(String name, double totalAmount, int totalFrequentRenterPoint, List<Rental> rentals){
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoint = totalFrequentRenterPoint;
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
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoint
                + " frequent renter points";
        return result;
    }
}
