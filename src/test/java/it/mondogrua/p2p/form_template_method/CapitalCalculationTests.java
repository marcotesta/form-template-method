package it.mondogrua.p2p.form_template_method;

import it.mondogrua.p2p.form_template_method.Factors;
import it.mondogrua.p2p.form_template_method.Loan;

import java.util.Date;

import org.junit.Test;

import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class CapitalCalculationTests extends TestCase {

    private static final double LOAN_AMOUNT = 3000.0;
    private static final double TWO_DIGIT_PRECISION = 0.001;

    @Test
    public void testTermLoanSamePayments()
    {
        Date start = november(20, 2003);
        Date maturity = november(20, 2006);
        Loan termLoan = Loan.newTermLoan(LOAN_AMOUNT, start, maturity, Factors.HIGH_RISK_RATING);
        termLoan.payment(1000.00, november(20, 2004));
        termLoan.payment(1000.00, november(20, 2005));
        termLoan.payment(1000.00, november(20, 2006));
        assertEquals("Duartion", 2.0, termLoan.duration(), TWO_DIGIT_PRECISION);
        assertEquals("Capital", 210.0, termLoan.capital(), TWO_DIGIT_PRECISION);
    }



    private Date november(int day, int year) {
        return new Date(year, 11, day);
    }
}
