package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import java.util.*

interface PedidoGateway {

    fun listarPedidos(): List<Pedido>

    fun criarPedido(pedido: Pedido): Pedido

    fun buscarPedidoPeloId(pedidoId: UUID): Optional<Pedido>

    fun pagarPedido(pedido: Pedido): Pedido
}
