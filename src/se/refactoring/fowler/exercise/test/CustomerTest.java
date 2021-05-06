package se.refactoring.fowler.exercise.test;

import org.junit.Before;
import org.junit.Test;
import se.refactoring.fowler.exercise.main.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Hans");
    }

    @Test
    public void getName() {
        assertEquals("Hans", customer.getName());
    }

    @Test
    public void statement() {
        String statement = "Rental Record for Hans" + "\n";
        statement += "Amount owed is " + "0.0" + "\n";
        statement += "You earned " + "0" + " frequent renter points";

        assertEquals(statement, customer.statement());
    }

}
