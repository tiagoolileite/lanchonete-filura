package br.com.fiap.lanchonetefilura.api.model.produto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotNull
import java.util.*

class PedidoRequest {
    @JsonProperty("cliente_id")
    val clienteId: UUID? = null

    @NotNull(message = "Lista de pedidos não pode estar nula")
    @JsonProperty("produtos_id")
    val produtosId: List<UUID>? = null
}