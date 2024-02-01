package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.domain.adapter.PedidoAdapter
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import br.com.fiap.lanchonetefilura.infra.dto.impl.ProdutoDTOImpl
import org.springframework.stereotype.Component

@Component
class PedidoAdapterImpl : PedidoAdapter {
    override fun adaptarListaDePedidos(pedidosDTO: List<PedidoDTO>): List<PedidoResponse> {
        TODO("Not yet implemented")
    }

    override fun adaptarPedido(
        clienteDTO: ClienteDTOImpl?,
        produtosDTO: List<ProdutoDTOImpl>,
        pedidoDTO: PedidoDTO
    ): PedidoResponse? {
        TODO("Not yet implemented")
    }

}