package app;

import java.util.Locale;

public class Struik extends Plant {
    private String bladsoort;

    public Struik(String naam, int hoogte, String bladsoort) {
        super(naam, hoogte);
        this.bladsoort = bladsoort.toUpperCase();
    }

    public String getBladsoort() {
        return bladsoort;
    }

    @Override
    public String toString() {
        return super.toString() + " " + bladsoort;
    }
}