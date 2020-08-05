package br.com.user.api.integration.converter

import br.com.user.api.domain.Github
import br.com.user.api.integration.response.GithubResponse
import org.mapstruct.Mapper

@Mapper
interface GithubResponseToGithubConverter {

    fun convert(githubResponse: GithubResponse): Github
}