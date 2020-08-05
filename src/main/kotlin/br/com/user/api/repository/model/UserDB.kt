package br.com.user.api.repository.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime


@Document(collection = "user")
data class UserDB(@Id val id: String?,
                  val name: String?,
                  val cpf: String?,
                  val email: String?,
                  val phone: String?) {
    @CreatedDate
    var createdDate: LocalDateTime? = null
    @LastModifiedDate
    var modifiedDate: LocalDateTime? = null
}