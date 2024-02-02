package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import br.com.fiap.lanchonetefilura.infra.repository.PedidoRepository
import br.com.fiap.lanchonetefilura.infra.repository.jpa.PedidoJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PedidoRepositoryImpl(
    private val repository: PedidoJpaRepository,
) : PedidoRepository {

    override fun listarPedidos(): List<Pedido> {
        return repository.findAll()
    }

    override fun criarPedido(pedido: Pedido): Pedido {


        return pedido.let { repository.save(it) } ?: throw Exception("Falha ao criar pedido")
    }

    override fun buscarPedidoPeloId(pedidoId: UUID): Optional<Pedido> {
        return repository.findById(pedidoId)
    }

    override fun pagarPedido(pedido : Pedido): Pedido {


        return pedido?.let { repository.save(it) } ?: throw Exception("Falha ao registrar pagamento do pedido")
    }
}