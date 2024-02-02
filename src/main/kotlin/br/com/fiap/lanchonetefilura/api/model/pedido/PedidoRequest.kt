package br.com.fiap.lanchonetefilura.api.model.pedido

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotNull
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class PedidoRequest (
    @JsonProperty("cliente_id")
    val clienteId: UUID,

    @NotNull(message = "Lista de pedidos não pode estar nula")
    @JsonProperty("produtos_id")
    val produtosId: List<UUID>
)