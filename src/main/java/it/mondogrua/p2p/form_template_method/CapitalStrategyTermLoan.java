package it.mondogrua.p2p.form_template_method;

public class CapitalStrategyTermLoan extends CapitalStrategy {


    public double capital(Loan loan) {
        return loan.getCommitment() * loan.duration() * riskFactor(loan);
    }

    public double duration(Loan loan) {
        return weightedAverageDuration(loan);
    }

}
