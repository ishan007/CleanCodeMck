package com.thoughtworks.movierental;

import java.util.List;

class HtmlStatement {

    private String name;
    private List<Rental> rentals;

    public HtmlStatement(String name, List<Rental> rentals){
        this.rentals = rentals;
        this.name = name;

    }
    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<h3>Rental Record for " + name + "<h3>";
    }

    private String htmlBody() {
        String result = "<p>";
        for (Rental rental : rentals) {
            result += rental.getMovie().getTitle() + "<b>" +
                    rental.amount() + "</b><br/>";
        }
        result += "</p>";
        return result;
    }

    private String htmlFooter() {
        return "<p>You earned <b> " + totalFrequentRenterPoint() + "</b> frequent renter points</p>";
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
