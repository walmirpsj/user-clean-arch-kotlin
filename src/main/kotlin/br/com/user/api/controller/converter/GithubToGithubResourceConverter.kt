package br.com.user.api.controller.converter

import br.com.user.api.controller.resource.GithubResource
import br.com.user.api.domain.Github
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface GithubToGithubResourceConverter {
    fun convert(github: Github): GithubResource
}
