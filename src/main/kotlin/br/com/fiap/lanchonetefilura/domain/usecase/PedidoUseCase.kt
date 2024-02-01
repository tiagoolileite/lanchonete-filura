package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import java.util.*

interface PedidoUseCase {
    fun listarPedidos(): List<PedidoDTO>

    fun criarPedido(clienteDTO: ClienteDTO?, produtosDTO: List<ProdutoDTO>): PedidoDTO

    fun buscarPedidoPeloId(pedidoId: UUID): PedidoDTO

    fun pagarPedido(pedidoDTO: PedidoDTO)
}
