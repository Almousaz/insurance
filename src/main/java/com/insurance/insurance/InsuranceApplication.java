package com.insurance.insurance;

import com.insurance.insurance.util.MortgageCalculator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class InsuranceApplication {


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


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:5174");
            }
        };
    }


}
