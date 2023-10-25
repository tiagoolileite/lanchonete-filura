package br.com.fiap.lanchonetefilura.adapter.driver.api.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalExceptionHandlerAdvice {

    @ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Falha ao processar solicitação")
    @ExceptionHandler
    fun genericError(exception: Exception): ResponseEntity<ApiError> {
        return ResponseEntity(
            ApiError(status = HttpStatus.BAD_GATEWAY.value(), message = "Erro ao processar solicitação"),
            HttpStatus.BAD_REQUEST)
    }

}