package br.com.fiap.lanchonetefilura.core.applications.usecases.implementateion

import br.com.fiap.lanchonetefilura.infra.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.infra.repository.PedidoRepository
import br.com.fiap.lanchonetefilura.infra.repository.ProdutoRepository
import br.com.fiap.lanchonetefilura.core.applications.usecases.PedidoUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.model.PedidoModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import br.com.fiap.lanchonetefilura.core.domain.request.PedidoRequest
import br.com.fiap.lanchonetefilura.core.exceptions.pedido.PedidoNaoEncontradoException
import br.com.fiap.lanchonetefilura.core.extensions.updateEtapaPedidoModel
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class PedidoUseCaseImpl(
    private val pedidoRepository: PedidoRepository,
    private val clienteRepository: ClienteRepository,
    private val produtoRepository: ProdutoRepository
) : PedidoUseCase {
    override fun getPedidos(): List<PedidoModel>? {

        return pedidoRepository.getPedidos()
    }

    override fun getPedidosFila(): List<PedidoModel>? {

        val pedidos = pedidoRepository.getPedidos()

        val pedidosFila: ArrayList<PedidoModel> = arrayListOf()

        pedidos?.forEach {
            if (etapasPossiveis.contains(it.etapa))
                pedidosFila.add(it)
        }

        return pedidosFila
    }

    override fun getPedidoById(pedidoId: UUID): PedidoModel? {

        val pedido = pedidoRepository.getPedidoById(pedidoId)

        pedido?.let {} ?: PedidoNaoEncontradoException()

        return pedido
    }


    override fun savePedido(pedidoRequest: PedidoRequest): PedidoModel? {

        var cliente: ClienteModel? = null

        pedidoRequest.clienteId?.let {
            cliente = clienteRepository.getClienteById(it)
        }

        val produtos = produtoRepository.getProdutos()

        val produtosModel: ArrayList<ProdutoModel> = arrayListOf()

        produtos?.forEach {
            if (pedidoRequest.produtosId.contains(it.id))
                produtosModel.add(it)
        }

        val pedidoModel = PedidoModel(cliente = cliente, produtos = produtosModel)

        return pedidoRepository.savePedido(pedidoModel)
    }

    override fun updateEtapaPedido(pedidoId: UUID, etapa: String): PedidoModel? {

        val pedido: PedidoModel? = pedidoRepository.getPedidoById(pedidoId = pedidoId)

        pedido?.let {} ?: throw PedidoNaoEncontradoException()

        return pedidoRepository.updateEtapaPedido(
            pedido.updateEtapaPedidoModel(etapa)
        )
    }

    override fun updateStatusPagamentoPedido(pedidoId: UUID): PedidoModel? {

        val pedido: PedidoModel? = pedidoRepository.getPedidoById(pedidoId = pedidoId)

        pedido?.let {} ?: throw PedidoNaoEncontradoException()

        pedido.pago = true // fake check

        return pedidoRepository.updateStatusPagamentoPedido(pedido.updateEtapaPedidoModel("Recebido"))
    }

    private val etapasPossiveis: ArrayList<String> = arrayListOf(
        "Recebido".lowercase(),
        "Em preparação".lowercase(),
        "Pronto".lowercase(),
        "Finalizado".lowercase()
    )
}