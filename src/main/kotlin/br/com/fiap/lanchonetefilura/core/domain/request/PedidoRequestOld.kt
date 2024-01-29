package br.com.fiap.lanchonetefilura.core.domain.request

import java.util.*

interface PedidoRequestOld {
     val clienteId: UUID?
     val produtosId: List<UUID>
}