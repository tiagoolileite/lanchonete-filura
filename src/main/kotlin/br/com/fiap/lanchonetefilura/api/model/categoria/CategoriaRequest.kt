package br.com.fiap.lanchonetefilura.api.model.categoria

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

class CategoriaRequest {
    @NotNull(message = "descricao não pode estar vazia")
    @NotEmpty(message = "descricao não pode estar vazio")
    val descricao: String? = null
}