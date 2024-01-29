package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO

interface PedidoGateway {

    abstract fun listarPedidos(): List<PedidoDTO>
}
