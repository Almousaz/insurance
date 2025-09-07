package com.insurance.insurance.model;




public class MortgageRequest {
    private int principal;
    private float annualInterest;
    private byte years;

    // Getters and Setters
    public int getPrincipal() { return principal; }
    public void setPrincipal(int principal) { this.principal = principal; }

    public float getAnnualInterest() { return annualInterest; }
    public void setAnnualInterest(float annualInterest) { this.annualInterest = annualInterest; }

    public byte getYears() { return years; }
    public void setYears(byte years) { this.years = years; }
}
