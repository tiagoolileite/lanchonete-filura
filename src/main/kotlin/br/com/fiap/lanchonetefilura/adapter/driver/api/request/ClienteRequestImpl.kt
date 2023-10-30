package br.com.fiap.lanchonetefilura.adapter.driver.api.request

import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

class ClienteRequestImpl(
    @NotNull(message = "cpf não pode estar vazio")
    @NotEmpty(message = "cpf não pode estar vazio")
    override val cpf: String,
    @NotNull(message = "nome não pode estar vazio")
    @NotEmpty(message = "nome não pode estar vazio")
    override val nome: String,
    @NotNull(message = "email não pode estar vazio")
    @NotEmpty(message = "email não pode estar vazio")
    override val email: String
) : ClienteRequest