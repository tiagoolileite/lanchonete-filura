package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import java.util.*

interface PedidoRepository {


    fun listarPedidos(): List<Pedido>

    fun criarOuAtualizarPedido(pedido: Pedido): Pedido

    fun buscarPedidoPeloId(pedidoId: UUID): Optional<Pedido>
}