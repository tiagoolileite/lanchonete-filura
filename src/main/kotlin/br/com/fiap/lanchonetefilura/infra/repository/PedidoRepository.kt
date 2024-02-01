package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.PedidoDTOImpl
import java.util.*

interface PedidoRepository {


    fun listarPedidos(): List<PedidoDTO>

    fun criarPedido(pedidoDomainDTO: PedidoDomainDTO): PedidoDTO

    fun buscarPedidoPeloId(pedidoId: UUID): Optional<PedidoDTOImpl>

    fun pagarPedido(pedidoDomainDTO: PedidoDomainDTO): PedidoDTO
}