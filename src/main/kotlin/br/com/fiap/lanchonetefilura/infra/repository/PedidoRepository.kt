package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import java.util.*

interface PedidoRepository {

    /*fun getPedidos(): List<PedidoDTO>?

    fun getPedidoById(pedidoId: UUID): PedidoDTO?

    fun savePedido(pedidoModel: PedidoDTO): PedidoDTO?

    fun updateEtapaPedido(pedidoModel: PedidoDTO): PedidoDTO?

    fun updateStatusPagamentoPedido(pedidoModel: PedidoDTO): PedidoDTO?*/

    fun listarPedidos(): List<PedidoDTO>

    fun criarPedido(pedidoDTO: PedidoDTO): PedidoDTO

    fun buscarPedidoPeloId(pedidoId: UUID): Optional<PedidoDTO>

    fun pagarPedido(pedidoDTO: PedidoDTO)
}