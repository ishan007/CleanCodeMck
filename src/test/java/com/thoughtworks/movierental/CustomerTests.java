
package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTests {
    @Test
    public void shouldGenerateStatement() {
        Customer customer = new Customer("ABC");
        customer.addRental(new Rental(new Movie("Movie-1", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Movie-2", Movie.CHILDRENS), 5));
        customer.addRental(new Rental(new Movie("Movie-2", Movie.NEW_RELEASE), 3));

        assertEquals("Rental Record for ABC\n" +
                "\tMovie-1\t5.0\n" +
                "\tMovie-2\t4.5\n" +
                "\tMovie-2\t9.0\n" +
                "Amount owed is 18.5\n" +
                "You earned 4 frequent renter points", customer.statement());
    }

    @Test
    public void shouldGenerateHTMLStatement() {
        Customer customer = new Customer("ABC");
        customer.addRental(new Rental(new Movie("Movie-1", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Movie-2", Movie.CHILDRENS), 5));
        customer.addRental(new Rental(new Movie("Movie-2", Movie.NEW_RELEASE), 3));

        assertEquals("<h3>Rental Record for ABC<h3><p>Movie-1<b>5.0</b><br/>Movie-2<b>4.5</b><br/>Movie-2<b>9.0</b><br/></p>" +
                "<p>You earned <b> 4</b> frequent renter points</p>", customer.htmlStatement());
    }
}