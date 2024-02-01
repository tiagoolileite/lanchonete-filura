package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.domain.adapter.PedidoAdapter
import br.com.fiap.lanchonetefilura.domain.controller.PedidoController
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import br.com.fiap.lanchonetefilura.domain.usecase.ClienteUseCase
import br.com.fiap.lanchonetefilura.domain.usecase.PedidoUseCase
import br.com.fiap.lanchonetefilura.domain.usecase.ProdutoUseCase
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.stereotype.Component
import java.util.*

@Component
class PedidoControllerImpl(
    val pedidoUseCase: PedidoUseCase,
    val clienteUseCase: ClienteUseCase,
    val produtoUseCase: ProdutoUseCase,
    val adater: PedidoAdapter
) : PedidoController {

    override fun listarPedidos(): List<PedidoResponse> {

        val pedidosDTO: List<PedidoDTO> = pedidoUseCase.listarPedidos()

        return adater.adaptarListaDePedidos(
            pedidosDTO = pedidosDTO
        )
    }

    override fun criarPedido(clienteId: UUID?, produtosId: List<UUID>?): PedidoResponse? {

        var clienteDTO: ClienteDTO? = null

        try {
            clienteDTO = clienteId?.let { clienteUseCase.buscarClientePeloId(it) }
        } catch (e: Exception) {
            LoggerHelper.logger.info("Cliente não informado ou não localizado")
        }

        val produtosDTO: List<ProdutoDomainDTO> =
            produtoUseCase.listarProdutosPorListaDeIds(produtosId)

        val pedidoDTO: PedidoDTO = pedidoUseCase.criarPedido(clienteDTO, produtosDTO)

        return adater.adaptarPedido(
            pedidoDTO = pedidoDTO,
            clienteDTO = pedidoDTO.cliente,
            produtosDTO = pedidoDTO.produtos
        )
    }

    override fun pagarPedido(pedidoId: UUID): PedidoResponse? {

        val pedidoDTO: PedidoDTO = pedidoUseCase.buscarPedidoPeloId(pedidoId)

        pedidoUseCase.pagarPedido(pedidoDTO)

        return adater.adaptarPedido(
            pedidoDTO = pedidoDTO,
            clienteDTO = pedidoDTO.cliente,
            produtosDTO = pedidoDTO.produtos
        )
    }
}