package br.com.user.api.repository.impl

import br.com.user.api.domain.User
import br.com.user.api.repository.UserRepository
import br.com.user.api.repository.converter.UserDBToUserConverter
import br.com.user.api.repository.converter.UserToUserDBConverter
import br.com.user.api.usecase.gateway.UserGateway
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Component
import java.util.*
import java.util.stream.Collectors

@Component
class UserGatewayImpl(val userRepository: UserRepository): UserGateway {

    override fun save(user: User) {
        val convert = Mappers.getMapper(UserToUserDBConverter::class.java).convert(user)
        userRepository.save(convert)
    }

    override fun delete(user: User) {
        userRepository.delete(Mappers.getMapper(UserToUserDBConverter::class.java).convert(user))
    }

    override fun findAll(): List<User> {
        return userRepository.findAll()
                .stream()
                .map { userDB -> Mappers.getMapper(UserDBToUserConverter::class.java).convert(userDB!!) }
                .collect(Collectors.toList())
    }

    override fun findByCpf(cpf: String): Optional<User> {
        return Optional.ofNullable(userRepository.findByCpf(cpf))
                .map { userDB -> Mappers.getMapper(UserDBToUserConverter::class.java).convert(userDB!!) }
    }
}