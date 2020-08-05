package br.com.user.api.usecase

import br.com.user.api.domain.User

interface UpdateUserUseCase {
    fun execute(user: User)
}