package br.com.user.api.usecase.gateway

import br.com.user.api.domain.Github

interface GithubGateway {
    fun shoot(username: String): Github
}