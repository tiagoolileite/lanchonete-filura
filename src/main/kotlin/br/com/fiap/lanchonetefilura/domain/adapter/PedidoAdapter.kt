package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.ProdutoDTOImpl

interface PedidoAdapter {
    fun adaptarListaDePedidos(
        pedidosDTO: List<PedidoDTO>
    ): List<PedidoResponse>

    fun adaptarPedido(
        clienteDTO: ClienteDTO?,
        produtosDTO: List<ProdutoDTOImpl>,
        pedidoDTO: PedidoDTO,
    ): PedidoResponse?
}
