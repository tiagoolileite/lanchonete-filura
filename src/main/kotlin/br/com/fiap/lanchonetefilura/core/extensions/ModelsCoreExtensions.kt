package br.com.fiap.lanchonetefilura.core.extensions

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel

fun ProdutoModel.editCategoriaModel(categoriaModel: CategoriaModel): ProdutoModel {
    return ProdutoModel(
        id = this.id,
        nome = this.nome,
        descricao = this.descricao,
        preco = this.preco,
        categoria = categoriaModel
    )
}