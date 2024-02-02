package br.com.fiap.lanchonetefilura.api.mapper

import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.entity.Produto

interface ProdutoMapper {
    fun mapeiaProdutosResponse(produtos : List<Produto>): List<ProdutoResponse>

    fun mapeiaProdutoResponse(produto: Produto): ProdutoResponse
}
