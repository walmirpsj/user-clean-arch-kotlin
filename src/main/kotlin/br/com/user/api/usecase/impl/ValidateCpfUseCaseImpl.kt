package br.com.user.api.usecase.impl

import br.com.caelum.stella.validation.CPFValidator
import br.com.caelum.stella.validation.InvalidStateException
import br.com.user.api.usecase.ValidateCpfUseCase
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class ValidateCpfUseCaseImpl : ValidateCpfUseCase {

    companion object{
        const val INVALID_CPF: String = "Invalid CPF"
    }

    override fun execute(cpf: String) {
        try {
            CPFValidator().assertValid(cpf)
        } catch (e: InvalidStateException) {
            throw HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY, INVALID_CPF)
        }
    }
}