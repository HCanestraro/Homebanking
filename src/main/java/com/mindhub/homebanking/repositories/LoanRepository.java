package com.mindhub.homebanking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.mindhub.homebanking.Models.Loan;

@RepositoryRestResource
public interface LoanRepository extends JpaRepository<Loan, Long> {

}