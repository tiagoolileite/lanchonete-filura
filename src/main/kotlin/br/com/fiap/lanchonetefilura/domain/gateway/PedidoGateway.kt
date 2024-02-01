package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import java.util.*

interface PedidoGateway {

    fun listarPedidos(): List<PedidoDomainDTO>

    fun criarPedido(pedidoDomainDTO: PedidoDomainDTO): PedidoDomainDTO

    fun buscarPedidoPeloId(pedidoId: UUID): Optional<PedidoDomainDTO>

    fun pagarPedido(pedidoDomainDTO: PedidoDomainDTO): PedidoDomainDTO
}
