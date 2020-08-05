package br.com.user.api.usecase.impl

import br.com.user.api.domain.User
import br.com.user.api.usecase.SaveUserUseCase
import br.com.user.api.usecase.gateway.UserGateway
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class SaveUserUseCaseImpl(val userGateway: UserGateway): SaveUserUseCase {

    override fun execute(user: User) {
        userGateway.findByCpf(user.cpf!!)
                .ifPresentOrElse({ userToSave -> getExceptionUserAlreadyExisting() }
                ) { userGateway.save(user) }
    }

    private fun getExceptionUserAlreadyExisting() {
        throw HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "User already existing")
    }
}