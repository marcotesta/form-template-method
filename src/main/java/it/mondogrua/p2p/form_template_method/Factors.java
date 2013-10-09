package it.mondogrua.p2p.form_template_method;

import java.util.HashMap;
import java.util.Map;

public class Factors {

    public static final int HIGH_RISK_RATING = 1;

    private Map<Integer, Double> factors = new HashMap<Integer, Double>();

    // Constructors -----------------------------------------------------------

    public Factors() {
    }

    // Public Methods ---------------------------------------------------------

    public double forRating(int rating) {
        return factors.get(rating);
    }

    // Protected or Package Methods -------------------------------------------

    void addFactor(int rating, double factor) {
        factors.put(rating, factor);
    }
}
