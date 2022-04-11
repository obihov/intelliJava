package javaobinnaProject;

import java.util.Scanner;

public class MortgageInputConsole {

    //Encapsulate - data hiding
    private static double principal = 0;
    private static double annualInterestRate = 0;
    private static double totalNumberOfYearlyPayments = 0;


    //Constants
    private static final Scanner CONSOLE = new Scanner(System.in);
    private static final int MONTHS_IN_YEAR = 12;
    private static final int PERCENT = 100;


    public MortgageInputConsole() {

    }

    private static void setPrincipal() {

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = CONSOLE.nextDouble();
            if (principal >= 1000 && principal <= 1_000_000) {
                break;
            }
            System.out.println("Enter a number between 1,000 and 1,000,000 US dollars");
        }
    }

    public static double getPrincipal() {
        setPrincipal();
        return principal;
    }

    private static void setAnnualInterestRate() {

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = CONSOLE.nextDouble();
            if (annualInterestRate > 0 && annualInterestRate <= 30) {
                annualInterestRate = annualInterestRate / PERCENT;  //convert to percentage
                break;
            }
            System.out.println("Enter a value between 0.1 and 30 percent rate.");
        }
    }

    public static double getMonthlyInterestRate() {
        double monthlyInterestRate;
        setAnnualInterestRate();
        monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;  //represented in monthly rates
        return monthlyInterestRate;
    }

    private static void setNumberOfYearlyPayments() {

        while (true) {
            System.out.print("Period (Years): ");
            totalNumberOfYearlyPayments = CONSOLE.nextDouble();
            if (totalNumberOfYearlyPayments < 1 || totalNumberOfYearlyPayments > 30) {
                System.out.println("Enter a value between 1 and 30 years.");
                continue;
            }
            break;
        }
    }

    public static double getTotalNumberOfMonthlyPayments() {
        double totalNumberOfMonthlyPayments;
        setNumberOfYearlyPayments();
        totalNumberOfMonthlyPayments = totalNumberOfYearlyPayments *  MONTHS_IN_YEAR;  //represented in number of months in total
        return totalNumberOfMonthlyPayments;
    }

}
