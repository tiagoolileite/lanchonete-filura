package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO

interface PedidoUseCase {
    fun listarPedidos(): List<PedidoDTO>

}
