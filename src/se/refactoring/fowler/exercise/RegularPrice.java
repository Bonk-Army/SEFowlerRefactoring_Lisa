package se.refactoring.fowler.exercise;

public class RegularPrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}
