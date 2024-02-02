package br.com.fiap.lanchonetefilura.persistence.adapter

import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import br.com.fiap.lanchonetefilura.persistence.dto.PedidoDTO

interface PedidoAdapter {
    fun adaptarPedidosDTOParaPedidos(pedidosDTO : List<PedidoDTO>) : List<Pedido>

    fun adaptarPedidoParaPedidoDTO(pedido : Pedido) : PedidoDTO

    fun adaptarPedidoDTOParaPedido(pedidoDTO : PedidoDTO) : Pedido

}
