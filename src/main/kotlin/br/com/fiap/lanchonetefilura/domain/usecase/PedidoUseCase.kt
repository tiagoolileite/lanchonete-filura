package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import java.util.*

interface PedidoUseCase {
    fun listarPedidos(): List<PedidoDomainDTO>

    fun criarPedido(clienteId: UUID?, produtosId: List<UUID>): PedidoDomainDTO

    fun pagarPedido(pedidoId: UUID): PedidoDomainDTO?
}
