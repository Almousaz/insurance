package com.insurance.insurance;

public class MortgageCalculator {

      private int principal;
      private float annualInterest;
      private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public short getYears() {
        return years;
    }

    public  double calculateMortgage() {


        float numberOfPayments = years * InsuranceApplication.MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest / InsuranceApplication.PERCENT / InsuranceApplication.MONTHS_IN_YEAR;


        double mortgage = principal * (monthlyInterest *
                Math.pow(1 + monthlyInterest, numberOfPayments)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;


    }

    public  double calculateBalance(short numberOfPaymentsMade) {

        float numberOfPayments = years * InsuranceApplication.MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest / InsuranceApplication.PERCENT / InsuranceApplication.MONTHS_IN_YEAR;

        double balance = principal *
                (Math.pow(1 + monthlyInterest, numberOfPayments) -
                        Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;


    }
}
