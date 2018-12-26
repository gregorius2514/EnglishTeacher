package pl.english.teacher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@ComponentScan("pl.english")
class SpringBootMain

fun main(args: Array<String>) {
   runApplication<SpringBootMain>(*args)
}