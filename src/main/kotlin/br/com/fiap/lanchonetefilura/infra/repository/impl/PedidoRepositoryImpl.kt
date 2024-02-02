package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.domain.entity.Pedido
import br.com.fiap.lanchonetefilura.infra.adapter.PedidoAdapter
import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import br.com.fiap.lanchonetefilura.infra.repository.PedidoRepository
import br.com.fiap.lanchonetefilura.infra.repository.jpa.PedidoJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PedidoRepositoryImpl(
    private val repository: PedidoJpaRepository,
    private val adapter: PedidoAdapter
) : PedidoRepository {

    override fun listarPedidos(): List<Pedido> {

        val pedidosDTO: List<PedidoDTO> = repository.findAll()

        return adapter.adaptarPedidosDTOParaPedidos(pedidosDTO)
    }

    override fun criarOuAtualizarPedido(pedido: Pedido): Pedido {

        var pedidoDTO: PedidoDTO = adapter.adaptarPedidoParaPedidoDTO(pedido)

        pedidoDTO = repository.save(pedidoDTO)

        return adapter.adaptarPedidoDTOParaPedido(pedidoDTO)
    }

    override fun buscarPedidoPeloId(pedidoId: UUID): Optional<Pedido> {

        val pedidoDTO: Optional<PedidoDTO> = repository.findById(pedidoId)

        return Optional.of(adapter.adaptarPedidoDTOParaPedido(pedidoDTO = pedidoDTO.get()))
    }
}