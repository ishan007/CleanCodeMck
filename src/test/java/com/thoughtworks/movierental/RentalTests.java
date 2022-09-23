package com.thoughtworks.movierental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RentalTest {

    @Test
    public void GivenMoviesAndDaysRented_WhenAmountIsInvoked_ShouldReturnAmount(){
        Rental rental = new Rental(new Movie("Sholay", Movie.NEW_RELEASE), 10);

        double expectedAmount = 30.0;
        double actualAmount = rental.amount();

        Assertions.assertEquals(expectedAmount, actualAmount);
    }


    @Test
    public void GivenMoviesAndDaysRented_WhenFrequentRenterPointsIsInvoked_ShouldReturnRenterPoints(){
        Rental rental = new Rental(new Movie("Darr", Movie.NEW_RELEASE), 2);

        double expectedPoints = 2;
        double actualPoints = rental.frequentRenterPoint();

        Assertions.assertEquals(expectedPoints, actualPoints);
    }

}
