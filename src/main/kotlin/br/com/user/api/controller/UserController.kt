package br.com.user.api.controller

import br.com.user.api.controller.converter.GithubToGithubResourceConverter
import br.com.user.api.controller.converter.UserResourceToUserConverter
import br.com.user.api.controller.converter.UserToUserResourceConverter
import br.com.user.api.controller.resource.GithubResource
import br.com.user.api.controller.resource.UserResource
import br.com.user.api.usecase.*
import io.swagger.annotations.ApiOperation
import org.mapstruct.factory.Mappers
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController(
        val saveUserUseCase: SaveUserUseCase,
        val updateUserUseCase: UpdateUserUseCase,
        val deleteUserUseCase: DeleteUserUseCase,
        val findAllUserUseCase: FindAllUserUseCase,
        val validateCpfUseCase: ValidateCpfUseCase,
        val findGitHubUseCase: FindGitHubUseCase
){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Register user")
    fun save(@RequestBody userResource: @Valid UserResource) {
        validateCpfUseCase.execute(userResource.cpf!!)
        saveUserUseCase.execute(Mappers.getMapper(UserResourceToUserConverter::class.java).convert(userResource))
    }

    @PutMapping
    @ApiOperation("Update user")
    fun update(@RequestBody userResource: @Valid UserResource) {
        validateCpfUseCase.execute(userResource.cpf!!)
        updateUserUseCase.execute(Mappers.getMapper(UserResourceToUserConverter::class.java).convert(userResource))
    }

    @DeleteMapping("/{cpf}")
    @ApiOperation("Delete user by CPF")
    fun delete(@PathVariable cpf: String) {
        validateCpfUseCase.execute(cpf)
        deleteUserUseCase.execute(cpf)
    }

    @GetMapping
    @ApiOperation("Find all users")
    fun findAll(): List<UserResource> {
        var teste = UserResource("", "", "", "")
        return findAllUserUseCase.execute()
                .stream()
                .map { user -> Mappers.getMapper(UserToUserResourceConverter::class.java).convert(user) }
                .collect(Collectors.toList())
    }

    @GetMapping("/github/{username}")
    @ApiOperation("Find GitHub User")
    fun findGitHubUser(@PathVariable username: String): GithubResource {
        val github = findGitHubUseCase.execute(username)
        return Mappers.getMapper(GithubToGithubResourceConverter::class.java).convert(github)
    }
}
