package br.com.fiap.lanchonetefilura.api.mapper

import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO

interface ProdutoMapper {
    fun mapeiaProdutosResponse(produtosDTO: List<ProdutoDomainDTO>): List<ProdutoResponse>

    fun mapeiaProdutoResponse(produtoDTO: ProdutoDomainDTO): ProdutoResponse
}
