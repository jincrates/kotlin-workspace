package me.jincrates.bookmanager.domain.loan

import org.springframework.data.jpa.repository.JpaRepository

interface LoanRepository : JpaRepository<Loan, Long> {
}