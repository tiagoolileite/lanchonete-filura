package br.com.fiap.lanchonetefilura.adapter.driver.api.extensions

import br.com.fiap.lanchonetefilura.adapter.driver.api.request.CategoriaRequest
import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ProdutoRequest
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel

fun converterCategoriaRequestToCategoriaModel(categoria: CategoriaRequest): CategoriaModel {
    return CategoriaModel(descricao = categoria.descricao)
}

fun converterProdutorequestToProdutoModel(produtoRequest: ProdutoRequest, categoria: CategoriaModel?): ProdutoModel {
    return ProdutoModel(
        nome = produtoRequest.nome,
        descricao = produtoRequest.descricao,
        preco = produtoRequest.preco,
        categoria = categoria
    )
}

fun converterFindAllProdutosToArrayList(produtosIterable: Iterable<ProdutoModel>): ArrayList<ProdutoModel> {
    val produtos = arrayListOf<ProdutoModel>()
    produtosIterable.forEach { produtos.add(it) }

    return produtos
}

fun converterFindAllCategoriasToArrayList(categoriaIterable: List<CategoriaModel>): ArrayList<CategoriaModel>? {
    val categorias = arrayListOf<CategoriaModel>()
    categoriaIterable.forEach { categorias.add(it) }

    return categorias
}