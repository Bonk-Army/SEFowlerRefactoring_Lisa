package se.refactoring.fowler.exercise;

class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }

    double getCharge() {
        double result = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR -> {
                result += 2;
                if (getDaysRented() > 2)
                    result += (getDaysRented() - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> result += getDaysRented() * 3;
            case Movie.CHILDRENS -> {
                result += 1.5;
                if (getDaysRented() > 3)
                    result += (getDaysRented() - 3) * 1.5;
            }
        }
        return result;
    }

    int getFrequentRenterPoints() {
        if((getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
        getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }

    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }

    private double amountFor(Rental aRental) {
        return aRental.getCharge();
    }


}
