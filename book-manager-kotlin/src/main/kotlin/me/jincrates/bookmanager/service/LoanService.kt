package me.jincrates.bookmanager.service

import me.jincrates.bookmanager.domain.books.BookRepository
import me.jincrates.bookmanager.domain.loan.Loan
import me.jincrates.bookmanager.domain.loan.LoanBook
import me.jincrates.bookmanager.domain.loan.LoanRepository
import me.jincrates.bookmanager.domain.members.MemberRepository
import me.jincrates.bookmanager.web.http.dto.LoanDto
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Transactional
@Service
class LoanService(
    private val bookRepository: BookRepository,
    private val memberRepository: MemberRepository,
    private val loanRepository: LoanRepository
) {

    fun loan(loanDto: LoanDto, memberId: Long): Optional<Loan>? {

        val book = bookRepository.findById(loanDto.bookId)
        val member = memberRepository.findById(memberId)

        val loanBooks = mutableListOf<LoanBook>()
        val loanBook = LoanBook().createLoanBook(book, loanDto.count)
        loanBooks.add(loanBook)

        val loan = Loan().createLoan(member, loanBooks)
        loanRepository.save(loan)

        return loan.id?.let { loanRepository.findById(it) }
    }
}