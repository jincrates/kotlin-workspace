package me.jincrates.bookmanager.web.http.dto

import com.fasterxml.jackson.annotation.JsonProperty
import me.jincrates.bookmanager.common.annotation.StringFormatDateTime
import me.jincrates.bookmanager.domain.books.Book
import me.jincrates.bookmanager.domain.loan.Loan
import me.jincrates.bookmanager.domain.members.Member
import javax.persistence.*

class LoanDto(

    @JsonProperty("book_id")
    var bookId: Long,

    @JsonProperty("member_id")
    var memberId: Long,

    var count: Int
)


/*

{
    "loan_id": "",
    "from_date": "",
    "to_date": "",
    "is_return": "",
    "member": ""

}
*/