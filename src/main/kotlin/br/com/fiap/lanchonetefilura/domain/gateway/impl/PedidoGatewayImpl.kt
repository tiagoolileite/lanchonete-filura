package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.gateway.PedidoGateway
import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import br.com.fiap.lanchonetefilura.infra.repository.PedidoRepository
import org.springframework.stereotype.Component

@Component
class PedidoGatewayImpl(val repository: PedidoRepository) : PedidoGateway {
    override fun listarPedidos(): List<PedidoDTO> {
        return repository.listarPedidos()
    }
}