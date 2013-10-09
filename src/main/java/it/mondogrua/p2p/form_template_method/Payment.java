package it.mondogrua.p2p.form_template_method;

import java.util.Date;

public class Payment {

    private double amount;
    private Date date;

    // Constructor ------------------------------------------------------------

    public Payment(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    // Public Methods ---------------------------------------------------------

    public double amount() {
        return this.amount;
    }

    public Date date() {
        return date;
    }

}
