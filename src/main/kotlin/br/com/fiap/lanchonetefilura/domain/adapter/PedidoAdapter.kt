package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import br.com.fiap.lanchonetefilura.infra.dto.impl.ProdutoDTOImpl

interface PedidoAdapter {
    fun adaptarListaDePedidos(
        pedidosDTO: List<PedidoDTO>
    ): List<PedidoResponse>

    fun adaptarPedido(
        clienteDTO: ClienteDTOImpl?,
        produtosDTO: List<ProdutoDTOImpl>,
        pedidoDTO: PedidoDTO,
    ): PedidoResponse?
}
