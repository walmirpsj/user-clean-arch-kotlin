package br.com.user.api.usecase.impl

import br.com.user.api.domain.User
import br.com.user.api.usecase.UpdateUserUseCase
import br.com.user.api.usecase.gateway.UserGateway
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class UpdateUserUseCaseImpl(val userGateway: UserGateway): UpdateUserUseCase {

    override fun execute(user: User) {
        userGateway.findByCpf(user.cpf!!)
           .ifPresentOrElse({userSaved ->
               val userToUpdate = User(userSaved.id!!, user.name!!, user.cpf!!, user.email!!, user.phone)
               userGateway.save(userToUpdate) }) {getExceptionUserNotFound()}
    }

    private fun getExceptionUserNotFound() {
        throw HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "User not found to update")
    }
}