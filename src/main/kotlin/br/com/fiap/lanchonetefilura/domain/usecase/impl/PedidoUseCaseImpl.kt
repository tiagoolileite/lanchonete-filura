package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import br.com.fiap.lanchonetefilura.domain.gateway.PedidoGateway
import br.com.fiap.lanchonetefilura.domain.usecase.PedidoUseCase
import org.springframework.stereotype.Component
import java.util.*

@Component
class PedidoUseCaseImpl(
    val gateway: PedidoGateway
) : PedidoUseCase {

    override fun listarPedidos(): List<PedidoDTO> {
        return gateway.listarPedidos()
    }

    override fun criarPedido(
        clienteDTO: ClienteDTO?, produtosDTO: List<ProdutoDTO>
    ): PedidoDTO {

        val pedidoDTO = PedidoDTO(
            cliente = clienteDTO,
            //TODO produtos = produtosDTO,
            preco = calculaPreco(produtosDTO)
        )

        return gateway.criarPedido(pedidoDTO)
    }

    private fun calculaPreco(produtosDTO: List<ProdutoDTO>): Double {

        val precoTotal = 0.0

        produtosDTO.forEach { produto ->
            produto.preco?.let { precoProduto -> precoTotal.plus(precoProduto) }
        }

        return precoTotal
    }

    override fun buscarPedidoPeloId(pedidoId: UUID): PedidoDTO {

        val pedidoDTO: Optional<PedidoDTO> = gateway.buscarPedidoPeloId(pedidoId)

        if (pedidoDTO.isEmpty) {
            throw Exception("Não foi possível localizar pedido")
        }

        return pedidoDTO.get()
    }

    override fun pagarPedido(pedidoDTO: PedidoDTO) {
        //TODO Pagar pelo pedido
        pedidoDTO.pago = true

        gateway.pagarPedido(pedidoDTO)
    }
}