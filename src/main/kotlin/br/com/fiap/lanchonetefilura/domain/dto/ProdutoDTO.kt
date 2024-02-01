package br.com.fiap.lanchonetefilura.domain.dto

import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import java.util.*

interface ProdutoDTO {
    var id: UUID?

    var nome: String?

    var descricao: String?

    var preco: Double?

    var categoria: CategoriaDTOImpl?

    val pedidos: List<PedidoDTO>?
}