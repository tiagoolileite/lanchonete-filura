package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import java.util.*

interface PedidoUseCase {
    fun listarPedidos(): List<PedidoDTO>

    fun criarPedido(clienteDTO: ClienteDTOImpl?, produtosDTO: List<ProdutoDomainDTO>): PedidoDTO

    fun buscarPedidoPeloId(pedidoId: UUID): PedidoDTO

    fun pagarPedido(pedidoDTO: PedidoDTO)
}
