package it.mondogrua.p2p.form_template_method;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 */
public class Loan
{

    private double commitment;
    private Date start;
    private Date expiry;
    private Date maturity;
    private int riskRating;
    private double unusedPesentage;
    private double outstanding;

    private Date today;

    private Collection<Payment> payments = new ArrayList<Payment>();
    private CapitalStrategy capitalStrategy;


    // Constructor, Creation and Initialization Methods -----------------------

    public Loan(double commitment, Date start, Date expiry, Date maturity,
            int riskRating, CapitalStrategy capitalStrategy) {
        this.commitment = commitment;
        this.start = start;
        this.maturity = maturity;
        this.riskRating = riskRating;
        this.capitalStrategy = capitalStrategy;
    }

    public static Loan newTermLoan(double commitment, Date start,
            Date maturity, int riskRating) {
        return new Loan(commitment, start, null, maturity, riskRating, new CapitalStrategyTermLoan());
    }

    public static Loan newRevolverLoan(double commitment, Date expiry,
            Date maturity, int riskRating) {
        return new Loan(commitment, null, expiry, maturity, riskRating, new CapitalStrategyRevolverLoan());
    }

    public static Loan newAdvisedLine(double commitment, Date expiry,
            Date maturity, int riskRating) {
        if (riskRating > 3) {
            return null;
        }
        Loan advisedLine = new Loan(commitment, null, expiry, maturity, riskRating, new CapitalStrategyAdvisedLine());
        advisedLine.setUnusedPesentage(1.0);
        return advisedLine;
    }

    // Public Methods ---------------------------------------------------------

    public double capital() {
        return capitalStrategy.capital(this);
    }

    public double duration() {
        return capitalStrategy.duration(this);
    }

    // Protected or Package Protected Methods ---------------------------------

    void payment(double amount, Date date) {
        Payment payment = new Payment(amount, date);
        payments.add(payment);

    }

    // Private Methods --------------------------------------------------------

    double outstandingRiskAmount() {
        return outstanding;
    }

    private void setUnusedPesentage(double unusedPesentage) {
        this.unusedPesentage = unusedPesentage;
    }

    double unusedRiskAmount() {
        return (commitment - outstanding);
    }



    double getUnusedPersentage() {
        return this.unusedPesentage;
    }

    Date getExpiry() {
        return this.expiry;
    }

    Date getMaturity() {
        return this.maturity;
    }

    double getCommitment() {
        return this.commitment;
    }

    int getRiskRating() {
        return this.riskRating;
    }

    Collection<Payment> getPayments() {
        return this.payments;
    }

    Date getToday() {
        return this.today;
    }

    Date getStart() {
        return this.start;
    }
}
