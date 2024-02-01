package br.com.fiap.lanchonetefilura.domain.dto

import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDomainDTOImpl
import java.util.*

interface ProdutoDomainDTO {
    val id: UUID?

    var nome: String?

    var descricao: String?

    var preco: Double?

    var categoria: CategoriaDomainDTOImpl?

    val pedidos: List<PedidoDomainDTOImpl>?
}