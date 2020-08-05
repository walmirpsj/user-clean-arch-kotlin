package br.com.user.api.usecase

import br.com.user.api.domain.Github

interface FindGitHubUseCase {
    fun execute(username: String): Github
}