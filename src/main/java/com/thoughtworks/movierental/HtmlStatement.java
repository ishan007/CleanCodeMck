package com.thoughtworks.movierental;

import java.util.List;

class HtmlStatement {

    private String name;
    private int totalFrequentRenterPoint;
    private List<Rental> rentals;

    public HtmlStatement(String name, int totalFrequentRenterPoint, List<Rental> rentals){
        this.totalFrequentRenterPoint = totalFrequentRenterPoint;
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
        return "<p>You earned <b> " + totalFrequentRenterPoint + "</b> frequent renter points</p>";
    }


}
