package br.com.fiap.lanchonetefilura.domain.dto

import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.CategoriaDTOImpl
import java.util.*

interface ProdutoDomainDTO {
    var id: UUID?

    var nome: String?

    var descricao: String?

    var preco: Double?

    var categoria: CategoriaDTOImpl?

    val pedidos: List<PedidoDTO>?
}