package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO

interface PedidoRepository {

    /*fun getPedidos(): List<PedidoDTO>?

    fun getPedidoById(pedidoId: UUID): PedidoDTO?

    fun savePedido(pedidoModel: PedidoDTO): PedidoDTO?

    fun updateEtapaPedido(pedidoModel: PedidoDTO): PedidoDTO?

    fun updateStatusPagamentoPedido(pedidoModel: PedidoDTO): PedidoDTO?*/

    fun listarPedidos(): List<PedidoDTO>
}