package br.com.fiap.lanchonetefilura.domain.dto

import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.dto.impl.ProdutoDomainDTOImpl
import java.util.*

interface PedidoDomainDTO {

    val id: UUID?

    var senha: Int?

    val etapa: String

    val cliente: ClienteDomainDTOImpl?

    val produtos: List<ProdutoDomainDTOImpl>

    var preco: Double

    var pago: Boolean
}