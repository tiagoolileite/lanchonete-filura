package br.com.fiap.lanchonetefilura.core.domain.request

import java.util.UUID

interface PedidoRequest {
     val clienteId: UUID?
     val produtosId: List<UUID>
}