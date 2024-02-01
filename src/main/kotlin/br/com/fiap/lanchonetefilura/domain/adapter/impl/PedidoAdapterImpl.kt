package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.adapter.ClienteAdapter
import br.com.fiap.lanchonetefilura.domain.adapter.PedidoAdapter
import br.com.fiap.lanchonetefilura.domain.adapter.ProdutoAdater
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.ProdutoDTO
import org.springframework.stereotype.Component

@Component
class PedidoAdapterImpl(
    val produtoAdapter: ProdutoAdater,
    val clienteAdapter: ClienteAdapter,
) : PedidoAdapter {
    override fun adaptarListaDePedidos(
        pedidosDTO: List<PedidoDTO>
    ): List<PedidoResponse> {

        val pedidosResponse: ArrayList<PedidoResponse> = arrayListOf()

        pedidosDTO.forEach { pedido ->

            val produtosAdaptados: List<ProdutoResponse> =
                produtoAdapter.adaptarListaDeProdutos(pedido.produtos)

            val clienteAdaptado: ClienteResponse? =
                pedido.cliente?.let { cliente -> clienteAdapter.adaptarCliente(cliente) }

            pedidosResponse.add(PedidoResponse(
                id = pedido.id,
                cliente = clienteAdaptado,
                senha = pedido.senha,
                etapa = pedido.etapa,
                produtos = produtosAdaptados,
                preco = pedido.preco,
                pago = pedido.pago
            ))
        }

        return  pedidosResponse
    }

    override fun adaptarPedido(
        clienteDTO: ClienteDTO?,
        produtosDTO: List<ProdutoDTO>,
        pedidoDTO: PedidoDTO
    ): PedidoResponse {

        val clienteAdaptado: ClienteResponse =
            clienteAdapter.adaptarCliente(clienteDTO)

        val produtosAdaptados: List<ProdutoResponse> =
            produtoAdapter.adaptarListaDeProdutos(produtosDTO)

        return PedidoResponse(
            id = pedidoDTO.id,
            senha = pedidoDTO.senha,
            etapa = pedidoDTO.etapa,
            preco = pedidoDTO.preco,
            pago = pedidoDTO.pago,
            cliente = clienteAdaptado,
            produtos = produtosAdaptados
        )
    }
}