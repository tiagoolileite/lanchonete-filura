package br.com.fiap.lanchonetefilura.infra.repository

import java.util.*

interface PedidoRepository {

    fun getPedidos(): List<PedidoModel>?

    fun getPedidoById(pedidoId: UUID): PedidoModel?

    fun savePedido(pedidoModel: PedidoModel): PedidoModel?

    fun updateEtapaPedido(pedidoModel: PedidoModel): PedidoModel?

    fun updateStatusPagamentoPedido(pedidoModel: PedidoModel): PedidoModel?
}