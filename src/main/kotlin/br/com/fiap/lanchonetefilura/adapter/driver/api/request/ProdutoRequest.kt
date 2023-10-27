package br.com.fiap.lanchonetefilura.adapter.driver.api.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.util.UUID

data class ProdutoRequest (
    @NotNull(message = "nome não pode estar vazio")
    @NotEmpty(message = "nome não pode estar vazio")
    val nome: String,
    @NotNull(message = "descricao não pode estar vazia")
    @NotEmpty(message = "descricao não pode estar vazia")
    val descricao: String,
    @NotNull(message = "preco não pode estar vazio")
    @NotEmpty(message = "preco não pode estar vazio")
    val preco: Double,
    @NotNull(message = "categoria não pode estar vazio")
    @NotEmpty(message = "categoria não pode estar vazio")
    val categoria: UUID
)
