package me.jincrates.bookmanager.domain.loan

import org.springframework.data.jpa.repository.JpaRepository

interface LoanBookRepository : JpaRepository<LoanBook, Loan> {
}