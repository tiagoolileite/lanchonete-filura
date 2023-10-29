package br.com.fiap.lanchonetefilura.adapter.driver.api.response

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import java.util.UUID

data class ProdutoResponse(
    var id: UUID? = null,
    var nome: String? = null,
    var descricao: String? = null,
    var preco: Double? = null,
    var categoria: CategoriaModel? = null
)