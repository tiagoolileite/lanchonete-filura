package br.com.fiap.lanchonetefilura.api.model.categoria

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

@JsonIgnoreProperties(ignoreUnknown = true)
data class CategoriaRequest (
    @NotNull(message = "descricao não pode estar vazia")
    @NotEmpty(message = "descricao não pode estar vazio")
    @JsonProperty("descricao")
    val descricao : String
)