package br.com.fiap.lanchonetefilura.adapter

import java.util.*

data class PedidoResponse (
    val id: UUID,
    val senha: Int? = null,
    val etapa: String,
    val cliente: ClienteModel? = null,
    val produtos: List<ProdutoModel>,
    val pago: Boolean
)
