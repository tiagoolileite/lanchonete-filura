package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import java.util.*

interface PedidoGateway {

    fun listarPedidos(): List<PedidoDTO>

    fun criarPedido(pedidoDTO: PedidoDTO): PedidoDTO

    fun buscarPedidoPeloId(pedidoId: UUID): Optional<PedidoDTO>

    fun pagarPedido(pedidoDTO: PedidoDTO)
}
