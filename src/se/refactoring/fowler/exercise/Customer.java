package se.refactoring.fowler.exercise;

import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer (String newname){
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }
    public String getName (){
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental aRental = (Rental) enum_rentals.nextElement();
            thisAmount = amountFor(aRental);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((aRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && aRental.getDaysRented() > 1)
                frequentRenterPoints ++;
            //show figures for this rental
            result += "\t" + aRental.getMovie().getTitle()+ "\t" + "\t" + aRental.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double amountFor(Rental aRental) {
        double result = 0;
        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR -> {
                result += 2;
                if (aRental.getDaysRented() > 2)
                    result += (aRental.getDaysRented() - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> result += aRental.getDaysRented() * 3;
            case Movie.CHILDRENS -> {
                result += 1.5;
                if (aRental.getDaysRented() > 3)
                    result += (aRental.getDaysRented() - 3) * 1.5;
            }
        }
        return result;
    }

}
