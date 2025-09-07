package com.insurance.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InsuranceApplication {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;


    public static void main(String[] args) {
        SpringApplication.run(InsuranceApplication.class, args);


        int principal = (int) Console.readNumber("Principal :  ", 1000, 1_000_000);

        float annualInterest = (float) Console.readNumber("Annual Interest Rate :  ", 1, 30);

        byte years = (byte) Console.readNumber("Period (Years) :  ", 1, 30);


        var calculator = new MortgageCalculator(principal, annualInterest, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();


    }


}
