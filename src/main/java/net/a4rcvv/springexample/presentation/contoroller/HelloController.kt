package net.a4rcvv.springexample.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

  @GetMapping("/hello")
  public fun hello(): String {
    return "Hello from Kotlin!"
  }
}
