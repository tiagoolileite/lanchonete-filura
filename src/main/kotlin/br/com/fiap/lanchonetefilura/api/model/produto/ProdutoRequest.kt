package br.com.fiap.lanchonetefilura.api.model.produto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class ProdutoRequest (
    @NotNull(message = "nome não pode estar vazio")
    @NotEmpty(message = "nome não pode estar vazio")
    @JsonProperty("nome")
    val nome: String?,

    @NotNull(message = "descricao não pode estar vazia")
    @NotEmpty(message = "descricao não pode estar vazia")
    @JsonProperty("descricao")
    val descricao: String?,

    @NotNull(message = "preco não pode estar vazio")
    @NotEmpty(message = "preco não pode estar vazio")
    @JsonProperty("preco")
    val preco: Double?,

    @NotNull(message = "categoria não pode estar vazio")
    @NotEmpty(message = "categoria não pode estar vazio")
    @JsonProperty("categoria_id")
    val categoriaId: UUID?
)
