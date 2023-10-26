package br.com.fiap.lanchonetefilura

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan
@EntityScan
@EnableAutoConfiguration
class LanchonetefiluraApplication
fun main(args: Array<String>) {
	runApplication<LanchonetefiluraApplication>(*args)
}
