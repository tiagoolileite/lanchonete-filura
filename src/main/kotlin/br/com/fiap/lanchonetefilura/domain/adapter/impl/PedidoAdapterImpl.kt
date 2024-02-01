package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.domain.adapter.ClienteAdapter
import br.com.fiap.lanchonetefilura.domain.adapter.PedidoAdapter
import br.com.fiap.lanchonetefilura.domain.adapter.ProdutoAdapter
import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import org.springframework.stereotype.Component

@Component
class PedidoAdapterImpl (
    val clienteAdapter : ClienteAdapter,
    val produtoAdapter : ProdutoAdapter
) : PedidoAdapter {

    override fun adaptarDadosIniciaisPeidoDomainDtoParaPedido(
        clienteDomainDTO : ClienteDomainDTO?,
        produtosDomainDTO : List<ProdutoDomainDTO>
    ) : Pedido {
        val cliente: Cliente = clienteAdapter.adaptarClienteDomainDtoParaCliente(clienteDomainDTO)
        val produtos: List<Produto> = produtoAdapter.adaptarProdutosDomainDtoParaProdutos(produtosDomainDTO)

        return Pedido(cliente = cliente, produtos = produtos)
    }

    override fun adaptarPedidoParaPedidoDomainDto(pedido : Pedido) : PedidoDomainDTO {
        return pedido.senha?.let {
            PedidoDomainDTOImpl(
                senha = it,
                produtos = produtoAdapter.adaptarProdutosParaProdutosDomainDto(pedido.produtos),
                etapa = pedido.etapa,
                cliente = pedido.cliente?.let { it1 -> clienteAdapter.adaptarClienteParaClienteDomainDto(it1) },
                preco = pedido.preco,
                pago = pedido.pago
                )
        } ?: throw Exception("Falha ao converter Pedido em PedidoDomainDTO")
    }

    override fun adaptarPedidosDtoEmPedidosDomainDto(pedidosDTO : List<PedidoDTO>) : List<PedidoDomainDTO> {
        return pedidosDTO.map { pedidoDTO ->
            PedidoDomainDTOImpl(
                id = pedidoDTO.id,
                senha = pedidoDTO.senha,
                etapa = pedidoDTO.etapa,
                cliente = pedidoDTO.cliente?.let { clienteAdapter.adaptarClienteDtoParaDomainDto(it) },
                produtos = produtoAdapter.adaptarProdutosDtoParaDomainDtoImpl(pedidoDTO.produtos),
                preco = pedidoDTO.preco,
                pago = pedidoDTO.pago
            )
        }
    }

    override fun adaptarPedidoDtoEmPedidoDomainDto(pedidoDTO : PedidoDTO) : PedidoDomainDTO {
        return PedidoDomainDTOImpl(
            id = pedidoDTO.id,
            senha = pedidoDTO.senha,
            etapa = pedidoDTO.etapa,
            cliente = pedidoDTO.cliente?.let { clienteAdapter.adaptarClienteDtoParaDomainDto(it) },
            produtos = produtoAdapter.adaptarProdutosDtoParaDomainDtoImpl(pedidoDTO.produtos),
            preco = pedidoDTO.preco,
            pago = pedidoDTO.pago
        )
    }

}