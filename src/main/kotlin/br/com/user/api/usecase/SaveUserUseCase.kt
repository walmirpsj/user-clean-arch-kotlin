package br.com.user.api.usecase

import br.com.user.api.domain.User

interface SaveUserUseCase {
    fun execute(user: User)
}