package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

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
        return new TextStatement().generate();
    }

    public String htmlStatement() {
        return new HtmlStatement().generate();
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

    private class TextStatement {
        public String generate() {
            return header() + body() + footer();
        }

        private String header() {
            return "Rental Record for " + getName() + "\n";
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
    }

    private class HtmlStatement {
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
    }
}