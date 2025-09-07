package com.insurance.insurance.controller;


import com.insurance.insurance.model.Mortgage;
import com.insurance.insurance.model.MortgageRequest;
import com.insurance.insurance.service.MortgageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/mortgage")
public class MortgageController {

    private final MortgageService mortgageService;

    public MortgageController(MortgageService mortgageService) {
        this.mortgageService = mortgageService;
    }

    @PostMapping("/calculate")
    public Map<String, Object> calculate(@RequestBody MortgageRequest request) {
        return mortgageService.calculateAndSaveMortgage(request);
    }

    @GetMapping("/history")
    public List<Mortgage> getHistory() {
        return mortgageService.getAllMortgages();
    }
}
