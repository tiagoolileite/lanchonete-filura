package br.com.fiap.lanchonetefilura.api.mapper.impl

import br.com.fiap.lanchonetefilura.api.mapper.ClienteMapper
import br.com.fiap.lanchonetefilura.api.mapper.PedidoMapper
import br.com.fiap.lanchonetefilura.api.mapper.ProdutoMapper
import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.stereotype.Component

@Component
class PedidoMapperImpl (
    val clienteMapper : ClienteMapper,
    val produtoMapper : ProdutoMapper
) : PedidoMapper {
    override fun mapeiaPedidosResponse(pedidosDomainDTO : List<PedidoDomainDTO>) : List<PedidoResponse> {
        return pedidosDomainDTO.map { pedidoDomainDTO ->
            mapeiaPedidoResponse(pedidoDomainDTO = pedidoDomainDTO)
        }
    }

    override fun mapeiaPedidoResponse(pedidoDomainDTO : PedidoDomainDTO?) : PedidoResponse {
        return pedidoDomainDTO?.id?.let { pedidoDomain ->
            PedidoResponse(
                id = pedidoDomain,
                senha = pedidoDomainDTO.senha,
                etapa = pedidoDomainDTO.etapa,
                cliente = pedidoDomainDTO.cliente?.let { clienteMapper.mapeiaClienteResponse(it) },
                produtos = produtoMapper.mapeiaProdutosResponse(pedidoDomainDTO.produtos),
                preco = pedidoDomainDTO.preco,
                pago = pedidoDomainDTO.pago
            )
        } ?: also {
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: " +
                    "Falha ao mapear dados para response")
        }.run {
            throw Exception("Falha ao mapear dados para response")
        }
    }
}