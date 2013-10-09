package it.mondogrua.p2p.form_template_method;

public class RiskFactor {

    private static Factors factors = new Factors();

    static {
        factors.addFactor(Factors.HIGH_RISK_RATING, 0.035);
    }

    public static Factors getFactors() {
        return factors;
    }

}
