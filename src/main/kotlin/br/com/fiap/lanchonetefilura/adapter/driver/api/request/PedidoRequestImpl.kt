package br.com.fiap.lanchonetefilura.adapter.driver.api.request

import br.com.fiap.lanchonetefilura.core.domain.request.PedidoRequest
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotNull
import java.util.*

class PedidoRequestImpl(

    @JsonProperty("categoria_id")
    override val clienteId: UUID? = null,

    @NotNull(message = "Lista de pedidos não pode estar nula")
    @JsonProperty("produtos_id")
    override val produtosId: List<UUID>

) : PedidoRequest