package br.com.fiap.lanchonetefilura.persistence.adapter.impl

import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import br.com.fiap.lanchonetefilura.persistence.adapter.ClienteAdapter
import br.com.fiap.lanchonetefilura.persistence.adapter.PedidoAdapter
import br.com.fiap.lanchonetefilura.persistence.adapter.ProdutoAdapter
import br.com.fiap.lanchonetefilura.persistence.dto.PedidoDTO
import org.springframework.stereotype.Component

@Component
class PedidoAdapterImpl (
    private val produtoAdapter : ProdutoAdapter,
    private val clienteAdapter : ClienteAdapter
) : PedidoAdapter {
    override fun adaptarPedidosDTOParaPedidos(pedidosDTO : List<PedidoDTO>) : List<Pedido> {
        return pedidosDTO.map { pedidoDTO ->
            adaptarPedidoDTOParaPedido(pedidoDTO)
        }
    }

    override fun adaptarPedidoParaPedidoDTO(pedido : Pedido) : PedidoDTO {
        return PedidoDTO(
            id = pedido.id,
            etapa = pedido.etapa,
            cliente = pedido.cliente?.let { clienteAdapter.adaptarClienteParaClienteDTO(cliente = it) },
            produtos = produtoAdapter.adaptarProdutosParaProdutosDTO(pedido.produtos),
            preco = pedido.preco,
            pago = pedido.pago
        )
    }

    override fun adaptarPedidoDTOParaPedido(pedidoDTO : PedidoDTO) : Pedido {
        return Pedido(
            id = pedidoDTO.id,
            senha = pedidoDTO.senha,
            etapa = pedidoDTO.etapa,
            cliente = pedidoDTO.cliente?.let { clienteAdapter.adaptarClienteDTOParaCliente(it) },
            produtos = produtoAdapter.adaptarProdutosDTOParaProdutos(produtosDTO = pedidoDTO.produtos),
            preco = pedidoDTO.preco,
            pago = pedidoDTO.pago
        )
    }
}