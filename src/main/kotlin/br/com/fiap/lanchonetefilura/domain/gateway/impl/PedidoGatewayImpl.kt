package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import br.com.fiap.lanchonetefilura.domain.gateway.PedidoGateway
import br.com.fiap.lanchonetefilura.infra.repository.PedidoRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class PedidoGatewayImpl(val repository: PedidoRepository) : PedidoGateway {
    override fun listarPedidos(): List<PedidoDTO> {
        return repository.listarPedidos()
    }

    override fun criarPedido(pedidoDTO: PedidoDTO): PedidoDTO {
        return repository.criarPedido(pedidoDTO = pedidoDTO)
    }

    override fun buscarPedidoPeloId(pedidoId: UUID): Optional<PedidoDTO> {
        return repository.buscarPedidoPeloId(pedidoId = pedidoId)
    }

    override fun pagarPedido(pedidoDTO: PedidoDTO) {
        return repository.pagarPedido(pedidoDTO = pedidoDTO)
    }
}