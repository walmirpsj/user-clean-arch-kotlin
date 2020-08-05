package br.com.user.api.usecase.gateway

import br.com.user.api.domain.User
import java.util.*

interface UserGateway {
    fun save(user: User)
    fun delete(user: User)
    fun findAll(): List<User>
    fun findByCpf(cpf: String): Optional<User>
}