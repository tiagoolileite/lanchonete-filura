package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.adapter.PedidoAdapter
import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import br.com.fiap.lanchonetefilura.domain.gateway.PedidoGateway
import br.com.fiap.lanchonetefilura.domain.usecase.ClienteUseCase
import br.com.fiap.lanchonetefilura.domain.usecase.PedidoUseCase
import br.com.fiap.lanchonetefilura.domain.usecase.ProdutoUseCase
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.stereotype.Component
import java.util.*

@Component
class PedidoUseCaseImpl(
    val gateway: PedidoGateway,
    val adapter: PedidoAdapter,
    val produtoUseCase: ProdutoUseCase,
    val clienteUseCase : ClienteUseCase
) : PedidoUseCase {

    override fun listarPedidos(): List<PedidoDomainDTO> {
        return gateway.listarPedidos()
    }

    override fun criarPedido(
        clienteId: UUID?, produtosId: List<UUID>
    ): PedidoDomainDTO {

        val clienteDomainDTO: ClienteDomainDTO? = clienteId?.let { clienteUseCase.buscarClientePeloId(it) }

        val produtosDomainDTO: List<ProdutoDomainDTO> = produtoUseCase.listarProdutosPorListaDeIds(produtosId)

        val pedido: Pedido = adapter.adaptarDadosIniciaisPeidoDomainDtoParaPedido(clienteDomainDTO, produtosDomainDTO)

        LoggerHelper.logger.info("Failure: " + pedido.etapa)
        LoggerHelper.logger.info("Failure: " + pedido.preco)
        LoggerHelper.logger.info("Failure: " + pedido.pago)
        LoggerHelper.logger.info("Failure: " + pedido.senha)
        LoggerHelper.logger.info("Failure: " + pedido.produtos[0])

        val pedidoDomainDTO: PedidoDomainDTO = adapter.adaptarPedidoParaPedidoDomainDto(pedido)

        return gateway.criarPedido(pedidoDomainDTO = pedidoDomainDTO)
    }

    private fun calculaPreco(produtosDTO: List<ProdutoDomainDTO>): Double {

        val precoTotal = 0.0

        produtosDTO.forEach { produto ->
            produto.preco?.let { precoProduto -> precoTotal.plus(precoProduto) }
        }

        return precoTotal
    }

    override fun pagarPedido(pedidoId: UUID): PedidoDomainDTO? {

        val pedidoDomainDTO: PedidoDomainDTO = buscarPedidoPeloId(pedidoId)

        var pedidoASerPagoDTO: PedidoDomainDTO? = null

        val fakeCheckout = true

        if (fakeCheckout)
            pedidoASerPagoDTO = gateway.pagarPedido(pedidoDomainDTO)

        return pedidoASerPagoDTO
    }

    fun buscarPedidoPeloId(pedidoId : UUID): PedidoDomainDTO {

        val pedidoDomainDTO: Optional<PedidoDomainDTO> = gateway.buscarPedidoPeloId(pedidoId)

        if (pedidoDomainDTO.isEmpty) {
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: " +
                    "Não foi possivel localizar seu pedido")
            throw Exception("Não foi possivel localizar seu pedido")
        }

        return pedidoDomainDTO.get()
    }
}