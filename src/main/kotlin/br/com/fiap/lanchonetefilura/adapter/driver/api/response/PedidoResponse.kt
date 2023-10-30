package br.com.fiap.lanchonetefilura.adapter.driver.api.response

import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import java.util.UUID

data class PedidoResponse (
    val id: UUID,
    val senha: Int? = null,
    val etapa: String,
    val cliente: ClienteModel? = null,
    val produtos: List<ProdutoModel>,
    val pago: Boolean
)
