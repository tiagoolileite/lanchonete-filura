package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse

interface ProdutoController {
    fun listarProdutos(): List<ProdutoResponse>

}
