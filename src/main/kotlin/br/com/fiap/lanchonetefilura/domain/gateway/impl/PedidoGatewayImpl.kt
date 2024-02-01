package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.adapter.PedidoAdapter
import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import br.com.fiap.lanchonetefilura.domain.gateway.PedidoGateway
import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.PedidoDTOImpl
import br.com.fiap.lanchonetefilura.infra.repository.PedidoRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class PedidoGatewayImpl(
    val repository: PedidoRepository,
    val adapter: PedidoAdapter
) : PedidoGateway {
    override fun listarPedidos(): List<PedidoDomainDTO> {

        val pedidosDTO: List<PedidoDTO> = repository.listarPedidos()

        return adapter.adaptarPedidosDtoEmPedidosDomainDto(pedidosDTO)
    }

    override fun criarPedido(pedidoDomainDTO: PedidoDomainDTO): PedidoDomainDTO {

        val pedidoDTO: PedidoDTO = repository.criarPedido(pedidoDomainDTO = pedidoDomainDTO)

        return adapter.adaptarPedidoDtoEmPedidoDomainDto(pedidoDTO)
    }

    override fun buscarPedidoPeloId(pedidoId: UUID): Optional<PedidoDomainDTO> {

        val pedidoDTO: Optional<PedidoDTOImpl> = repository.buscarPedidoPeloId(pedidoId = pedidoId)

        return Optional.of(
            adapter.adaptarPedidoDtoEmPedidoDomainDto(pedidoDTO.get())
        )
    }

    override fun pagarPedido(pedidoDomainDTO : PedidoDomainDTO): PedidoDomainDTO {

        val pedidoDTO: PedidoDTO = repository.pagarPedido(pedidoDomainDTO = pedidoDomainDTO)

        return adapter.adaptarPedidoDtoEmPedidoDomainDto(pedidoDTO)
    }
}