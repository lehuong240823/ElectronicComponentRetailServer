package org.example.electroniccomponentretailserver.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ErrorController {

    @RequestMapping("/error")
    fun handleError(request: HttpServletRequest): ResponseEntity<String> {
        val statusCode = request.getAttribute("javax.servlet.error.status_code") as? Int
        return when (statusCode) {
            HttpStatus.NOT_FOUND.value() -> ResponseEntity("Custom 404 Error: Page Not Found!", HttpStatus.NOT_FOUND)
            HttpStatus.INTERNAL_SERVER_ERROR.value() -> ResponseEntity("Custom 500 Error: Internal Server Error!", HttpStatus.INTERNAL_SERVER_ERROR)
            else -> ResponseEntity("Custom Error: Something went wrong.", HttpStatus.BAD_REQUEST)
        }
    }

}