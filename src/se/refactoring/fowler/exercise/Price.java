package se.refactoring.fowler.exercise;

abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

}

