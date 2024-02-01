package br.com.fiap.lanchonetefilura.infra.dto

import br.com.fiap.lanchonetefilura.infra.dto.impl.CategoriaDTOImpl
import java.util.*

interface ProdutoDTO {

    var id: UUID?

    var nome: String?

    var descricao: String?

    var preco: Double?

    var categoria: CategoriaDTOImpl?

    val pedidos: List<PedidoDTO>?
}