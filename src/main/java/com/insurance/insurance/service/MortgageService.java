package com.insurance.insurance.service;


import com.insurance.insurance.model.Mortgage;
import com.insurance.insurance.model.MortgageRequest;
import com.insurance.insurance.repository.MortgageRepository;
import com.insurance.insurance.util.MortgageCalculator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MortgageService {


    private final MortgageRepository mortgageRepository;

    public MortgageService(MortgageRepository mortgageRepository) {
        this.mortgageRepository = mortgageRepository;
    }

    public Map<String, Object> calculateAndSaveMortgage(MortgageRequest request) {
        MortgageCalculator calculator = new MortgageCalculator(
                request.getPrincipal(),
                request.getAnnualInterest(),
                request.getYears()
        );

        double monthlyPayment = calculator.calculateMortgage();

        Mortgage mortgage = new Mortgage(
                request.getPrincipal(),
                request.getAnnualInterest(),
                request.getYears(),
                monthlyPayment
        );

        mortgageRepository.save(mortgage);

        Map<String, Object> response = new HashMap<>();
        response.put("id", mortgage.getId());
        response.put("monthlyPayment", monthlyPayment);
        response.put("paymentSchedule", calculator.getRemainingBalance());

        return response;
    }

    public List<Mortgage> getAllMortgages() {
        return mortgageRepository.findAll();
    }

}
