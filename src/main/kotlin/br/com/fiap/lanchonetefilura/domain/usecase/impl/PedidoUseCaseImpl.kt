package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.domain.exceptions.pedido.PedidoNaoEncontradoException
import br.com.fiap.lanchonetefilura.domain.gateway.PedidoGateway
import br.com.fiap.lanchonetefilura.domain.usecase.ClienteUseCase
import br.com.fiap.lanchonetefilura.domain.usecase.PedidoUseCase
import br.com.fiap.lanchonetefilura.domain.usecase.ProdutoUseCase
import org.springframework.stereotype.Component
import java.util.*

@Component
class PedidoUseCaseImpl(
    val gateway: PedidoGateway,
    val clienteUseCase : ClienteUseCase,
    val produtoUseCase : ProdutoUseCase
) : PedidoUseCase {

    override fun listarPedidos(): List<Pedido> {
        return gateway.listarPedidos()
    }

    override fun criarPedido(
        clienteId: UUID?, produtosId: List<UUID>
    ): Pedido {

        val cliente: Cliente? = clienteId?.let { clienteUseCase.buscarClientePeloId(it) }

        val produtos: List<Produto> = produtoUseCase.listarProdutosPorListaDeIds(produtosId)

        val pedido = Pedido(
            etapa = Pedido.Companion.EtapasValidas.PENDENTE_PAGAMENTO.toString(),
            cliente = cliente,
            produtos = produtos,
            preco = calculaPreco(produtos)
        )

        return gateway.criarPedido(pedido = pedido)
    }

    private fun calculaPreco(produtos: List<Produto>): Double {

        var precoTotal = 0.0

        produtos.forEach { produto ->
            precoTotal = precoTotal.plus(produto.preco)
        }

        return precoTotal
    }

    override fun pagarPedido(pedidoId: UUID): Pedido? {

        val pedido: Pedido = buscarPedidoPeloId(pedidoId)

        val fakeCheckout = true

        if (fakeCheckout) {
            pedido.pago = true
            gateway.pagarPedido(pedido)
        }

        return pedido
    }

    fun buscarPedidoPeloId(pedidoId : UUID): Pedido {

        val pedido: Optional<Pedido> = gateway.buscarPedidoPeloId(pedidoId)

        if (pedido.isEmpty) {
            throw PedidoNaoEncontradoException()
        }

        return pedido.get()
    }
}