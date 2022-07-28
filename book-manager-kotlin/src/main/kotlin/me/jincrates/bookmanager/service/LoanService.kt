package me.jincrates.bookmanager.service

import me.jincrates.bookmanager.domain.books.BookRepository
import me.jincrates.bookmanager.domain.loans.Loan
import me.jincrates.bookmanager.domain.loans.LoanBook
import me.jincrates.bookmanager.domain.loans.LoanRepository
import me.jincrates.bookmanager.domain.members.MemberRepository
import me.jincrates.bookmanager.web.http.dto.LoanDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class LoanService(
    private val bookRepository: BookRepository,
    private val memberRepository: MemberRepository,
    private val loanRepository: LoanRepository
) {

    // C
    fun loan(loanDto: LoanDto, memberId: Long): Long? {
        val book = bookRepository.findById(loanDto.bookId)
        val member = memberRepository.findById(memberId)

        val loanBooks = mutableListOf<LoanBook>()
        val loanBook = LoanBook().createLoanBook(book, loanDto.count)
        loanBooks.add(loanBook)

        val loan = Loan().createLoan(member, loanBooks)
        loanRepository.save(loan)

        return loan.id;
    }

    // R
    fun read(id: Long) {
        return loanRepository.findById(id).get().let {

        }
    }


    // U

    // D
}