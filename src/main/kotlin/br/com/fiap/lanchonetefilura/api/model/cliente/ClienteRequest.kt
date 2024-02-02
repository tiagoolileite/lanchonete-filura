package br.com.fiap.lanchonetefilura.api.model.cliente

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

@JsonIgnoreProperties(ignoreUnknown = true)
data class ClienteRequest (
    @JsonProperty("cpf")
    val cpf: String,

    @NotNull(message = "nome não pode estar vazio")
    @NotEmpty(message = "nome não pode estar vazio")
    @JsonProperty("nome")
    val nome: String,

    @NotNull(message = "email não pode estar vazio")
    @NotEmpty(message = "email não pode estar vazio")
    @JsonProperty("email")
    val email: String
)
