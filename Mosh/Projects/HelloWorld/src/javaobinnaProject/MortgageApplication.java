package javaobinnaProject;

import java.util.Scanner;

public class MortgageApplication {

    private static final Scanner CONSOLE = new Scanner(System.in);


    public static void main(String[] args){
        boolean run = true;

        while (run) {
            double principal = MortgageInputConsole.getPrincipal();
            double monthlyInterestRate = MortgageInputConsole.getMonthlyInterestRate();
            double numberOfMonthlyPayments = MortgageInputConsole.getTotalNumberOfMonthlyPayments();

            var mortgageCalculator = new MortgageCalculator(principal, monthlyInterestRate, numberOfMonthlyPayments);
            var mortgageReport = new MortgageReport(mortgageCalculator); //with this approach, a report can utilize different calculator states/instances.
            mortgageReport.printMortgage();
            mortgageReport.printPaymentSchedule();

            System.out.println();
            System.out.println("Continue running program");
            System.out.println("Enter true to calculate new mortgage.\nEnter false to exit program.");
            run = CONSOLE.nextBoolean();
        }

        System.exit(0);
    }
}
