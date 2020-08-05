package br.com.user.api.exception

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiException(
        var status: HttpStatus,
        var message: String) {

    var HttpMessageNotReadableException: HttpMessageNotReadableException? = null
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    var timestamp: LocalDateTime = LocalDateTime.now()
    var debugMessage: String? = null

    constructor(status: HttpStatus, message: String,
                HttpMessageNotReadableException: HttpMessageNotReadableException) : this(status, message){
        this.HttpMessageNotReadableException = HttpMessageNotReadableException
    }

    constructor(status: HttpStatus,message: String, debugMessage: String) : this(status, message){
        this.message = message
        this.debugMessage = debugMessage
    }
}