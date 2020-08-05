//package br.com.user.api.controller
//
//import br.com.user.api.build.controller.UserResourceDataTestBuilder.Companion.getUserResource
//import br.com.user.api.build.domain.UserDataTestBuilder.Companion.getUser1
//import br.com.user.api.build.domain.UserDataTestBuilder.Companion.getUser2
//import br.com.user.api.domain.User
//import br.com.user.api.usecase.*
//import org.junit.Assert.*
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.ArgumentMatchers
//import org.mockito.ArgumentMatchers.anyString
//import org.mockito.InjectMocks
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.Mockito.*
//import org.mockito.junit.MockitoJUnitRunner
//import java.util.List
//
//@RunWith(MockitoJUnitRunner::class)
//class UserControllerTest(@InjectMocks
//                         val userController: UserController,
//                         @Mock
//                         val saveUserUseCase: SaveUserUseCase,
//                         @Mock
//                         val updateUserUseCase: UpdateUserUseCase,
//                         @Mock
//                         val deleteUserUseCase: DeleteUserUseCase,
//                         @Mock
//                         val findAllUserUseCase: FindAllUserUseCase,
//                         @Mock
//                         val validateCpfUseCase: ValidateCpfUseCase) {
//
//    @Test
//    fun shoulSaveUser() {
//        val userRequest = getUserResource()
//        doNothing().`when`(validateCpfUseCase).execute(anyString())
//        doNothing().`when`(saveUserUseCase).execute(ArgumentMatchers.any(User::class.java))
//        userController.save(userRequest!!)
//        verify(saveUserUseCase, Mockito.atLeastOnce()).execute(ArgumentMatchers.any(User::class.java))
////        verify(userResourceToUserConverter, Mockito.atLeastOnce()).convert(ArgumentMatchers.any(UserResource::class.java))
//    }
//
//    @Test
//    fun shoulUpdateUser() {
//        val userRequest = getUserResource()
//        doNothing().`when`(validateCpfUseCase).execute(anyString())
//        doNothing().`when`(updateUserUseCase).execute(ArgumentMatchers.any(User::class.java))
//        userController.update(userRequest!!)
//        verify(updateUserUseCase, Mockito.atLeastOnce()).execute(ArgumentMatchers.any(User::class.java))
////        verify(userResourceToUserConverter, Mockito.atLeastOnce()).convert(ArgumentMatchers.any(UserResource::class.java))
//    }
//
//    @Test
//    fun shoulDeleteUser() {
//        doNothing().`when`(validateCpfUseCase).execute(anyString())
//        doNothing().`when`(deleteUserUseCase).execute(anyString())
//        userController.delete("99999999999")
//        verify(deleteUserUseCase, Mockito.atLeastOnce()).execute(anyString())
//    }
//
//    @Test
//    fun shouldFindAll() {
//        val userResponse1 = getUser1()
//        val userResponse2 = getUser2()
//        Mockito.`when`(findAllUserUseCase.execute()).thenReturn(List.of(userResponse1, userResponse2))
//        val response = userController.findAll()
//        assertNotNull(response)
//        assertTrue(response!!.isNotEmpty())
//        assertEquals(userResponse1.cpf, response.stream().findFirst().get().cpf)
//        verify(findAllUserUseCase, Mockito.atLeastOnce()).execute()
////        verify(userToUserResourceConverter, Mockito.atLeastOnce()).convert(ArgumentMatchers.any(User::class.java))
//    }
//}
