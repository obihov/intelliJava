package javaobinnaProject;

public class MortgageCalculator {

    private final double monthlyInterestRate;
    private final double principal;

    public double getTotalNumberOfMonthlyPayments() {
        return totalNumberOfMonthlyPayments;
    }

    private final double totalNumberOfMonthlyPayments;

    public MortgageCalculator(double principal, double monthlyInterestRate, double totalNumberOfMonthlyPayments) {
        this.principal = principal;
        this.monthlyInterestRate = monthlyInterestRate;
        this.totalNumberOfMonthlyPayments = totalNumberOfMonthlyPayments;
    }

    public double CalculateMortgage() {
        double nominator = this.monthlyInterestRate * (Math.pow(1.0 + this.monthlyInterestRate, this.totalNumberOfMonthlyPayments));
        double denominator = (Math.pow(1.0 + this.monthlyInterestRate, this.totalNumberOfMonthlyPayments)) - 1.0;
        return this.principal * (nominator / denominator);
    }

    public double CalculateBalance(double numberOfPaymentsMade) {
        double nominator = this.principal * (Math.pow(1 + this.monthlyInterestRate, this.totalNumberOfMonthlyPayments) - Math.pow(1 + this.monthlyInterestRate, numberOfPaymentsMade));
        double denominator = (Math.pow(1 + this.monthlyInterestRate, this.totalNumberOfMonthlyPayments) - 1);
        return nominator / denominator;
    }
}