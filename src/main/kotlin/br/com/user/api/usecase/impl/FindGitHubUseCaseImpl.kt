package br.com.user.api.usecase.impl

import br.com.user.api.domain.Github
import br.com.user.api.usecase.FindGitHubUseCase
import br.com.user.api.usecase.gateway.GithubGateway
import org.springframework.stereotype.Service

@Service
class FindGitHubUseCaseImpl(val githubGateway: GithubGateway): FindGitHubUseCase {

    override fun execute(username: String): Github {
        return githubGateway.shoot(username)
    }
}