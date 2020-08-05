package br.com.user.api.integration

import br.com.user.api.integration.response.GithubResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "github-user", url = "https://api.github.com")
interface FindUserGithub {

    @GetMapping("/users/{login}")
    fun getUser(@PathVariable("login") login: String): GithubResponse
}
