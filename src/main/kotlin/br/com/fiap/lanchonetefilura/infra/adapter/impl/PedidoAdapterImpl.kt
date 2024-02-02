package br.com.fiap.lanchonetefilura.infra.adapter.impl

import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import br.com.fiap.lanchonetefilura.infra.adapter.PedidoAdapter
import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import org.springframework.stereotype.Component

@Component
class PedidoAdapterImpl : PedidoAdapter {
    override fun adaptarPedidosDTOParaPedidos(pedidosDTO : List<PedidoDTO>) : List<Pedido> {
        TODO("Not yet implemented")
    }

    override fun adaptarPedidoParaPedidoDTO(pedido : Pedido) : PedidoDTO {
        TODO("Not yet implemented")
    }

    override fun adaptarPedidoDTOParaPedido(pedidoDTO : PedidoDTO) : Pedido {
        TODO("Not yet implemented")
    }
}