package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import java.util.*

interface PedidoController {
    fun listarPedidos(): List<PedidoResponse>

    fun criarPedido(clienteId: UUID?, produtosId: List<UUID>?): PedidoResponse?

    fun pagarPedido(pedidoId: UUID): PedidoResponse
}
