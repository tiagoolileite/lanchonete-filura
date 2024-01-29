package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.infra.repository.jpa.PedidoJpaRepository
import br.com.fiap.lanchonetefilura.infra.repository.PedidoRepository
import br.com.fiap.lanchonetefilura.core.domain.model.PedidoModel
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PedidoRepositoryImpl(private val repository: PedidoJpaRepository) : PedidoRepository {
    override fun getPedidos(): List<PedidoModel>? {

        return repository.findAll()
    }

    override fun getPedidoById(pedidoId: UUID): PedidoModel? {

        return repository.findById(pedidoId).get()
    }

    override fun savePedido(pedidoModel: PedidoModel): PedidoModel? {

        return repository.save(pedidoModel)
    }

    override fun updateEtapaPedido(pedidoModel: PedidoModel): PedidoModel? {

        return repository.save(pedidoModel)
    }

    override fun updateStatusPagamentoPedido(pedidoModel: PedidoModel): PedidoModel? {

        return repository.save(pedidoModel)
    }
}