package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import java.util.*

interface PedidoUseCase {
    fun listarPedidos(): List<PedidoDTO>

    fun criarPedido(clienteDTO: ClienteDTO?, produtosDTO: List<ProdutoDTO>): PedidoDTO

    fun buscarPedidoPeloId(pedidoId: UUID): PedidoDTO

    fun pagarPedido(pedidoDTO: PedidoDTO)
}
