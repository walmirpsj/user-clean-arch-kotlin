package br.com.user.api.exception

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadable(ex: HttpMessageNotReadableException?,
                                              headers: HttpHeaders?, status: HttpStatus?,
                                              request: WebRequest?): ResponseEntity<Any?>? {
        val error = "Malformed JSON request"
        return buildResponseEntity(ApiException(status!!, error, ex!!))
    }

    private fun buildResponseEntity(apiException: ApiException): ResponseEntity<Any?>? {
        return ResponseEntity(apiException, apiException.status)
    }

    @ExceptionHandler(HttpClientErrorException::class)
    fun httpClientErrorExceptionHandler(ex: HttpClientErrorException): ResponseEntity<Any?>? {
        return buildResponseEntity(ApiException(ex.statusCode, ex.statusText, ex.message!!))
    }

    @ExceptionHandler(HttpServerErrorException::class)
    fun httpServerErrorExceptionHandler(ex: HttpServerErrorException): ResponseEntity<Any?>? {
        return buildResponseEntity(ApiException(ex.statusCode, ex.statusText, ex.message!!))
    }
}