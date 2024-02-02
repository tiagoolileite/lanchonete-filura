package br.com.fiap.lanchonetefilura.api.mapper

import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.domain.entity.Pedido

interface PedidoMapper {

    fun mapeiaPedidosResponse(pedidos : List<Pedido>) : List<PedidoResponse>

    fun mapeiaPedidoResponse(pedido : Pedido?) : PedidoResponse?

}
