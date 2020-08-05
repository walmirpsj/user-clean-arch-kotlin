package br.com.user.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.mongodb.config.EnableMongoAuditing

@SpringBootApplication
@EnableFeignClients
@EnableMongoAuditing
class UserApiApplication

fun main(args: Array<String>) {
    runApplication<UserApiApplication>(*args)
}