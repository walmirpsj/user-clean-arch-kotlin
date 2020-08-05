package br.com.user.api.usecase.impl

import br.com.user.api.domain.User
import br.com.user.api.usecase.FindAllUserUseCase
import br.com.user.api.usecase.gateway.UserGateway
import org.springframework.stereotype.Service

@Service
class FindAllUserUseCaseImpl(val userGateway: UserGateway): FindAllUserUseCase {

    override fun execute(): List<User> {
        return userGateway.findAll()
    }
}