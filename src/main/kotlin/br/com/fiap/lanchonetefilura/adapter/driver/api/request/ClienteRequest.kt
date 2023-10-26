package br.com.fiap.lanchonetefilura.adapter.driver.api.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class ClienteRequest (
    @NotNull(message = "cpf não pode estar vazio")
    @NotEmpty(message = "cpf não pode estar vazio")
    val cpf: String,
    @NotNull(message = "nome não pode estar vazio")
    @NotEmpty(message = "nome não pode estar vazio")
    val nome: String,
    @NotNull(message = "email não pode estar vazio")
    @NotEmpty(message = "email não pode estar vazio")
    val email: String
)