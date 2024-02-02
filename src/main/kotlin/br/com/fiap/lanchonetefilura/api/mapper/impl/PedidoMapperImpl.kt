package br.com.fiap.lanchonetefilura.api.mapper.impl

import br.com.fiap.lanchonetefilura.api.mapper.ClienteMapper
import br.com.fiap.lanchonetefilura.api.mapper.PedidoMapper
import br.com.fiap.lanchonetefilura.api.mapper.ProdutoMapper
import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import br.com.fiap.lanchonetefilura.domain.exceptions.pedido.PedidoNaoEncontradoException
import org.springframework.stereotype.Component

@Component
class PedidoMapperImpl (
    val clienteMapper : ClienteMapper,
    val produtoMapper : ProdutoMapper
) : PedidoMapper {
    override fun mapeiaPedidosResponse(pedidos : List<Pedido>) : List<PedidoResponse> {
        return pedidos.map { pedido ->
            mapeiaPedidoResponse(pedido = pedido)
        }
    }

    override fun mapeiaPedidoResponse(pedido : Pedido?) : PedidoResponse {
        if (pedido != null) {
            return PedidoResponse(
                id = pedido.id,
                senha = pedido.senha,
                etapa = pedido.etapa,
                cliente = pedido.cliente?.let { clienteMapper.mapeiaClienteResponse(it) },
                produtos = pedido.produtos.let { produtoMapper.mapeiaProdutosResponse(it) },
                preco = pedido.preco,
                pago = pedido.pago
            )
        } else {
            throw PedidoNaoEncontradoException()
        }
    }
}