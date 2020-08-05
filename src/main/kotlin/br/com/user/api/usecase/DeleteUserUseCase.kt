package br.com.user.api.usecase

interface DeleteUserUseCase {
    fun execute(cpf: String)
}