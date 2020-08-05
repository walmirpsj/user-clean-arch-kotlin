package br.com.user.api.integration.response

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

@JsonAutoDetect
data class GithubResponse(
        val login: String,
        val id: String,
        @JsonProperty("html_url") val htmlUrl: String?,
        val name: String?,
        val company: String?,
        val location: String?,
        val bio: String?,
        val followers: String?,
        val following: String?,
        @JsonProperty("avatar_url") val avatarUrl: String?,
        @JsonProperty("created_at") val createdAt: String?)