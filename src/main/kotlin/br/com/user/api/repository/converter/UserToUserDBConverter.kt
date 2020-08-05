package br.com.user.api.repository.converter

import br.com.user.api.domain.User
import br.com.user.api.repository.model.UserDB
import org.mapstruct.Mapper

@Mapper
interface UserToUserDBConverter {
    fun convert(user: User): UserDB
}