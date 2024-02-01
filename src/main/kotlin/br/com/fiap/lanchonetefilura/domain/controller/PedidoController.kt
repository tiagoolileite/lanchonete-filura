package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import java.util.*

interface PedidoController {
    fun listarPedidos(): List<PedidoDomainDTO>

    fun criarPedido(clienteId: UUID?, produtosId: List<UUID>?): PedidoDomainDTO?

    fun pagarPedido(pedidoId: UUID): PedidoDomainDTO?
}
