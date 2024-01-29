package br.com.fiap.lanchonetefilura.adapter.driver.api.request

import br.com.fiap.lanchonetefilura.core.domain.request.ProdutoRequest
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.util.*

data class ProdutoRequestImpl (

    @NotNull(message = "nome não pode estar vazio")
    @NotEmpty(message = "nome não pode estar vazio")
    override val nome: String,

    @NotNull(message = "descricao não pode estar vazia")
    @NotEmpty(message = "descricao não pode estar vazia")
    override val descricao: String,

    @NotNull(message = "preco não pode estar vazio")
    @NotEmpty(message = "preco não pode estar vazio")
    override val preco: Double,

    @NotNull(message = "categoria não pode estar vazio")
    @NotEmpty(message = "categoria não pode estar vazio")
    @JsonProperty("categoria_id")
    override val categoriaId: UUID
) : ProdutoRequest
