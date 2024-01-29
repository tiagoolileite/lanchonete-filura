package br.com.fiap.lanchonetefilura.api.model.cliente

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

class ClienteRequest {
    val cpf: String? = null

    @NotNull(message = "nome não pode estar vazio")
    @NotEmpty(message = "nome não pode estar vazio")
    val nome: String? = null

    @NotNull(message = "email não pode estar vazio")
    @NotEmpty(message = "email não pode estar vazio")
    val email: String? = null
}
