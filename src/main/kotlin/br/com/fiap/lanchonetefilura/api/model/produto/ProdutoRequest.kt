package br.com.fiap.lanchonetefilura.api.model.produto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.util.*

class ProdutoRequest {
    @NotNull(message = "nome não pode estar vazio")
    @NotEmpty(message = "nome não pode estar vazio")
    val nome: String? = null

    @NotNull(message = "descricao não pode estar vazia")
    @NotEmpty(message = "descricao não pode estar vazia")
    val descricao: String? = null

    @NotNull(message = "preco não pode estar vazio")
    @NotEmpty(message = "preco não pode estar vazio")
    val preco: Double? = null

    @NotNull(message = "categoria não pode estar vazio")
    @NotEmpty(message = "categoria não pode estar vazio")
    @JsonProperty("categoria_id")
    lateinit var categoriaId: UUID
}
