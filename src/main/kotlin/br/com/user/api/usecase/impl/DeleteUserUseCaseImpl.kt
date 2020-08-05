package br.com.user.api.usecase.impl

import br.com.user.api.usecase.DeleteUserUseCase
import br.com.user.api.usecase.gateway.UserGateway
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class DeleteUserUseCaseImpl(val userGateway: UserGateway) : DeleteUserUseCase {

    override fun execute(cpf: String) {
        userGateway.findByCpf(cpf)
                .ifPresentOrElse({ user -> userGateway.delete(user!!) }) { getExceptionUserNotFound() }
    }

    private fun getExceptionUserNotFound() {
        throw HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "User not found to delete")
    }
}