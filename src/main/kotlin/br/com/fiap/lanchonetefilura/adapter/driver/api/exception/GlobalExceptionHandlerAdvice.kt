package br.com.fiap.lanchonetefilura.adapter.driver.api.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalExceptionHandlerAdvice {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Verifique se informou todos os campos obrigatórios")
    @ExceptionHandler
    fun genericError(exception: HttpMessageNotReadableException): ResponseEntity<ApiError> {
        return ResponseEntity(
            ApiError(status = HttpStatus.BAD_REQUEST.value(), message = "Verifique se informou todos os campos obrigatório"),
            HttpStatus.BAD_REQUEST)
    }

    @ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Falha ao processar solicitação")
    @ExceptionHandler
    fun genericError(exception: Exception): ResponseEntity<ApiError> {
        return ResponseEntity(
            ApiError(status = HttpStatus.BAD_GATEWAY.value(), message = "Erro ao processar solicitação"),
            HttpStatus.BAD_GATEWAY)
    }

    @ResponseStatus(value = HttpStatus.ALREADY_REPORTED, reason = "Cliente já existe na base")
    @ExceptionHandler
    fun clienteJaExisteError(exception: ClienteJaExisteException): ResponseEntity<ApiError> {
        return ResponseEntity(
            ApiError(
                status = HttpStatus.ALREADY_REPORTED.value(),
                message = "Cliente já existe na base",
                entity = exception.entity?.let { exception.entity }
            ),
            HttpStatus.ALREADY_REPORTED)
    }

}