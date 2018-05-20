package com.example.SpringBootKotlin

import controller.AppController
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
open class SpringBootKotlinApplication {

    @Bean
    open fun controller() = AppController()
}

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinApplication>(*args)
}

