package br.com.user.api.controller.converter

import br.com.user.api.controller.resource.UserResource
import br.com.user.api.domain.User
import org.mapstruct.Mapper

@Mapper
interface UserResourceToUserConverter{
    fun convert(userResource: UserResource): User
}