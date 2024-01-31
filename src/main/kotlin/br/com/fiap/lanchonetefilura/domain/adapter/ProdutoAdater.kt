package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO

interface ProdutoAdater {
    fun adaptarListaDeProdutos(produtos: List<ProdutoDTO>): List<ProdutoResponse>

    fun adaptarProduto(produtoDTO: ProdutoDTO): ProdutoResponse
}
