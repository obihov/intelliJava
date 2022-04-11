package javaobinnaProject;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private final MortgageCalculator mortgageCalculator;
    private final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
    }

    public void printMortgage() {
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        double mortgage = mortgageCalculator.CalculateMortgage();
        System.out.println("First month mortgage payment: " + currencyFormatter.format(mortgage));
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        double totalNumberOfMonthlyPayments = mortgageCalculator.getTotalNumberOfMonthlyPayments();

        for (double numberOfPaymentsMade = 1; numberOfPaymentsMade <= totalNumberOfMonthlyPayments; numberOfPaymentsMade++) {
            double remainingBalance = mortgageCalculator.CalculateBalance(numberOfPaymentsMade);
            System.out.println("Remaining Balance after month " + numberOfPaymentsMade + " payment: " + currencyFormatter.format(remainingBalance));
        }
    }
}
