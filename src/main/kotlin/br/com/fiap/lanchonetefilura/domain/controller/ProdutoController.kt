package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import java.util.*

interface ProdutoController {
    fun listarProdutos(): List<ProdutoDomainDTO>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDomainDTO>

    fun cadastrarProduto(
        categoriaId: UUID,
        descricao: String?,
        nome: String?,
        preco: Double?
    ): ProdutoDomainDTO

    fun atualizaProduto(
        id: UUID,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): ProdutoDomainDTO

    fun deletarProdutoPeloId(produtoId: UUID)

}
