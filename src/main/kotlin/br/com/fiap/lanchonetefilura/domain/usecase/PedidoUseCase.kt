package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import java.util.*

interface PedidoUseCase {
    fun listarPedidos(): List<Pedido>

    fun criarPedido(clienteId: UUID?, produtosId: List<UUID>): Pedido

    fun pagarPedido(pedidoId: UUID): Pedido?
}
