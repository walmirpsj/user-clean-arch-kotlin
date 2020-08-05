package br.com.user.api.repository

import br.com.user.api.repository.model.UserDB
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<UserDB, String> {
    fun findByCpf(cpf: String): UserDB?
}