package dev.abreu.notetaking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NoteTakingApplication

fun main(args: Array<String>) {
    runApplication<NoteTakingApplication>(*args)
}
