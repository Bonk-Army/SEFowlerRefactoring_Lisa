package se.refactoring.fowler.exercise;

public class NewReleasesPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
