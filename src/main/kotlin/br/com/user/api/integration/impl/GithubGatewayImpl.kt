package br.com.user.api.integration.impl

import br.com.user.api.integration.FindUserGithub
import br.com.user.api.integration.response.GithubResponse
import br.com.user.api.domain.Github
import br.com.user.api.integration.converter.GithubResponseToGithubConverter
import br.com.user.api.usecase.gateway.GithubGateway
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Component

@Component
class GithubGatewayImpl(val findUserGithub: FindUserGithub) : GithubGateway {
    override fun shoot(username: String): Github {
        val githubResponse: GithubResponse = findUserGithub.getUser(login = username)
        return Mappers.getMapper(GithubResponseToGithubConverter::class.java).convert(githubResponse)
    }
}
