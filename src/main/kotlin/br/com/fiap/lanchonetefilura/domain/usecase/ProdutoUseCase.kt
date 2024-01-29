package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO

interface ProdutoUseCase {
    fun listarProdutos(): List<ProdutoDTO>
}
