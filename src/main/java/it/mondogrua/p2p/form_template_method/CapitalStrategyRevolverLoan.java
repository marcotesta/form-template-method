package it.mondogrua.p2p.form_template_method;

public class CapitalStrategyRevolverLoan extends CapitalStrategy {

    int pippo;

    public double capital(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPersentage() * loan.duration() * riskFactor(loan);
    }

    public double duration(Loan loan) {
        return yearsTo(loan.getExpiry(), loan);
    }
}
