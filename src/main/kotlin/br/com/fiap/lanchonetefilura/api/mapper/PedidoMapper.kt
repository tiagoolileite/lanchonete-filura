package br.com.fiap.lanchonetefilura.api.mapper

import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO

interface PedidoMapper {

    fun mapeiaPedidosResponse(pedidosDomainDTO : List<PedidoDomainDTO>) : List<PedidoResponse>

    fun mapeiaPedidoResponse(pedidoDomainDTO : PedidoDomainDTO?) : PedidoResponse?

}
