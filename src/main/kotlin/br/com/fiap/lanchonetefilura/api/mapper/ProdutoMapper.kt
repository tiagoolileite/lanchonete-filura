package br.com.fiap.lanchonetefilura.api.mapper

import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDTO

interface ProdutoMapper {
    fun mapeiaProdutosResponse(produtosDTO: List<ProdutoDTO>): List<ProdutoResponse>

    fun mapeiaProdutoResponse(produtoDTO: ProdutoDTO): ProdutoResponse
}
