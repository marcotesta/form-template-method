package it.mondogrua.p2p.form_template_method;

public class CapitalStrategyRevolverLoan extends CapitalStrategy {

    public double capital(Loan loan) {
        return (loan.outstandingRiskAmount() * loan.duration() * riskFactor(loan))
                + (loan.unusedRiskAmount() * loan.duration() * unusedRiskFactor(loan));
    }

    public double duration(Loan loan) {
        return yearsTo(loan.getExpiry(), loan);
    }
}
