package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse

interface PedidoController {
    fun listarPedidos(): List<PedidoResponse>
}
