package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import br.com.fiap.lanchonetefilura.domain.gateway.PedidoGateway
import br.com.fiap.lanchonetefilura.infra.repository.PedidoRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class PedidoGatewayImpl(
    val repository: PedidoRepository
) : PedidoGateway {
    override fun listarPedidos(): List<Pedido> {

        return repository.listarPedidos()
    }

    override fun criarPedido(pedido: Pedido): Pedido {

        return repository.criarOuAtualizarPedido(pedido)
    }

    override fun buscarPedidoPeloId(pedidoId: UUID): Optional<Pedido> {

        return repository.buscarPedidoPeloId(pedidoId)
    }

    override fun pagarPedido(pedido : Pedido): Pedido {

        return repository.criarOuAtualizarPedido(pedido)
    }
}