package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO

interface ProdutoGateway {
    fun listarProdutos(): List<ProdutoDTO>

}
