package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.domain.controller.PedidoController
import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import br.com.fiap.lanchonetefilura.domain.usecase.PedidoUseCase
import org.springframework.stereotype.Component
import java.util.*

@Component
class PedidoControllerImpl(
    val useCase: PedidoUseCase
) : PedidoController {

    override fun listarPedidos(): List<PedidoDomainDTO> {
        return useCase.listarPedidos()
    }

    override fun criarPedido(clienteId: UUID?, produtosId: List<UUID>?): PedidoDomainDTO? {
        return produtosId?.let { useCase.criarPedido(clienteId = clienteId, produtosId = it) }
    }

    override fun pagarPedido(pedidoId: UUID) : PedidoDomainDTO? {
        return useCase.pagarPedido(pedidoId = pedidoId)
    }
}