package me.jincrates.bookmanager.domain.loans

import org.springframework.data.jpa.repository.JpaRepository

interface LoanRepository : JpaRepository<Loan, Long> {
}