package com.insurance.insurance.model;


import jakarta.persistence.*;




@Entity
@Table(name = "mortgages")
public class Mortgage {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private int principal;
        private float annualInterest;
        private byte years;
        private double monthlyPayment;

        public Mortgage() {}

        public Mortgage(int principal, float annualInterest, byte years, double monthlyPayment) {
            this.principal = principal;
            this.annualInterest = annualInterest;
            this.years = years;
            this.monthlyPayment = monthlyPayment;
        }

        // Getters and setters
        public Long getId() { return id; }
        public int getPrincipal() { return principal; }
        public void setPrincipal(int principal) { this.principal = principal; }

        public float getAnnualInterest() { return annualInterest; }
        public void setAnnualInterest(float annualInterest) { this.annualInterest = annualInterest; }

        public byte getYears() { return years; }
        public void setYears(byte years) { this.years = years; }

        public double getMonthlyPayment() { return monthlyPayment; }
        public void setMonthlyPayment(double monthlyPayment) { this.monthlyPayment = monthlyPayment; }


}
