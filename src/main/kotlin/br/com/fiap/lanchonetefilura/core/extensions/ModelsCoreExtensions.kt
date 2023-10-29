package br.com.fiap.lanchonetefilura.core.extensions

import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ProdutoRequest
import br.com.fiap.lanchonetefilura.core.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel

fun converterProdutorequestToProdutoModel(produtoRequest: ProdutoRequest, categoria: CategoriaDTO?): ProdutoModel {
    return ProdutoModel(
        nome = produtoRequest.nome,
        descricao = produtoRequest.descricao,
        preco = produtoRequest.preco,
        categoria = CategoriaModel()
    )
}

fun converterFindAllProdutosToArrayList(produtosIterable: Iterable<ProdutoModel>): ArrayList<ProdutoModel> {
    val produtos = arrayListOf<ProdutoModel>()
    produtosIterable.forEach { produtos.add(it) }

    return produtos
}
