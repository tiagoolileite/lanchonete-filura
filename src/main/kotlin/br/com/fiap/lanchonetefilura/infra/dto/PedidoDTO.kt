package br.com.fiap.lanchonetefilura.infra.dto

import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import br.com.fiap.lanchonetefilura.infra.dto.impl.ProdutoDTOImpl
import java.util.*

interface PedidoDTO {
    val id: UUID?

    val senha: Int

    val etapa: String

    val cliente: ClienteDTOImpl?

    val produtos: List<ProdutoDTOImpl>

    var preco: Double

    var pago: Boolean
}