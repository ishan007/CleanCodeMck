package com.thoughtworks.movierental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    public void GivenNoRental_WhenStatementIsInvoked_ShouldReturnPlainStatement() {
        String expectedStatement = "Rental Record for Raj\n" +
                "Amount owed is 0.0" +
                "\nYou earned 0 frequent renter points";
        Customer customer = new Customer("Raj");
        String actualStatement = customer.statement();
        Assertions.assertEquals(expectedStatement, actualStatement);
    }


    @Test
    public void GivenRental_WhenStatementIsInvoked_ShouldReturnPlainStatement() {
        Customer customer = new Customer("Raj");
        customer.addRental(new Rental(new Movie("Baazigar", Movie.REGULAR), 10));


        String expectedStatement = "Rental Record for Raj\n" +
                "\tBaazigar\t14.0\n" +
                "Amount owed is 14.0\n" +
                "You earned 1 frequent renter points";

        String actualStatement = customer.statement();
        Assertions.assertEquals(expectedStatement, actualStatement);
    }


    @Test
    public void GivenRental_WhenStatementIsInvoked_ShouldReturnHtmlStatement(){
        Customer customer = new Customer("Raj");
        customer.addRental(new Rental(new Movie("Baazigar", Movie.REGULAR), 10));
        customer.addRental(new Rental(new Movie("Sholay", Movie.NEW_RELEASE), 10));
        customer.addRental(new Rental(new Movie("Raaz", Movie.NEW_RELEASE), 10));

        String expectedHtmlStatement = "<html>\n" +
                "<header>Rental Record for Raj</header>\n" +
                "<body>Baazigar\t14.0\n" +
                "Sholay\t30.0\n" +
                "Raaz\t30.0\n" +
                "</body>\n" +
                "<footer>\n" +
                "<p>Amount owed is 74.0</p>\n" +
                "<p>You earned 5 frequent renter points</p>\n" +
                "</footer>\n" +
                "</html>";

        String actualHtmlStatement = customer.htmlStatement();
        Assertions.assertEquals(expectedHtmlStatement, actualHtmlStatement);
    }
}