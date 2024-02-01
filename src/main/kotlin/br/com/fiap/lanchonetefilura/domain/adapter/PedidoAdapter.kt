package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO

interface PedidoAdapter {
    /*fun adaptarListaDePedidos(
        pedidosDTO: List<PedidoDTO>
    ): List<PedidoResponse>

    fun adaptarPedido(
        clienteDTO: ClienteDTOImpl?,
        produtosDTO: List<ProdutoDTOImpl>,
        pedidoDTO: PedidoDTO,
    ): PedidoResponse?*/

    fun adaptarDadosIniciaisPeidoDomainDtoParaPedido(
        clienteDomainDTO : ClienteDomainDTO?,
        produtosDomainDTO : List<ProdutoDomainDTO>
    ) : Pedido

    fun adaptarPedidoParaPedidoDomainDto(pedido : Pedido) : PedidoDomainDTO

    fun adaptarPedidosDtoEmPedidosDomainDto(pedidosDTO : List<PedidoDTO>) : List<PedidoDomainDTO>

    fun adaptarPedidoDtoEmPedidoDomainDto(pedidoDTO : PedidoDTO) : PedidoDomainDTO

    fun adaptarPedidoParaPedidoDomainDtoSemSenha(pedido : Pedido) : PedidoDomainDTO
}
