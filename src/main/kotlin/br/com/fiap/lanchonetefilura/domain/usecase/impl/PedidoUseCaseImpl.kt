package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.gateway.PedidoGateway
import br.com.fiap.lanchonetefilura.domain.usecase.PedidoUseCase
import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import org.springframework.stereotype.Component

@Component
class PedidoUseCaseImpl(val gateway: PedidoGateway) : PedidoUseCase {

    override fun listarPedidos(): List<PedidoDTO> {
        return gateway.listarPedidos()
    }
}