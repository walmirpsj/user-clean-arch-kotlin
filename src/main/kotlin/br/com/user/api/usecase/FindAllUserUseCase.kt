package br.com.user.api.usecase

import br.com.user.api.domain.User

interface FindAllUserUseCase {
    fun execute(): List<User>
}