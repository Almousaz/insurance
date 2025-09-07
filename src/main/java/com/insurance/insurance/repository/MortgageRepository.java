package com.insurance.insurance.repository;


import com.insurance.insurance.model.Mortgage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageRepository extends JpaRepository<Mortgage , Long> {

}
