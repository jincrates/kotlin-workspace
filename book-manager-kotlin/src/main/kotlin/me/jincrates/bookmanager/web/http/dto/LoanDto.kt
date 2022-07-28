package me.jincrates.bookmanager.web.http.dto

import com.fasterxml.jackson.annotation.JsonProperty

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