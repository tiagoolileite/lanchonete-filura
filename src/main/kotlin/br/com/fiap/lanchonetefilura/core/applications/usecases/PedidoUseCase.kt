package br.com.fiap.lanchonetefilura.core.applications.usecases

import br.com.fiap.lanchonetefilura.core.domain.model.PedidoModel
import br.com.fiap.lanchonetefilura.core.domain.request.PedidoRequestOld
import java.util.*

interface PedidoUseCase {

    fun getPedidos(): List<PedidoModel>?

    fun getPedidosFila(): List<PedidoModel>?

    fun getPedidoById(pedidoId: UUID): PedidoModel?

    fun savePedido(pedidoRequest: PedidoRequestOld): PedidoModel?

    fun updateEtapaPedido(pedidoId: UUID, etapa: String): PedidoModel?

    fun updateStatusPagamentoPedido(pedidoId: UUID): PedidoModel?
}