package br.com.fiap.lanchonetefilura.api.model.produto

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import java.util.*

data class ProdutoResponse(
    var id: UUID? = null,
    var nome: String? = null,
    var descricao: String? = null,
    var preco: Double? = null,
    var categoria: CategoriaResponse? = null
)