package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDTO
import java.util.*

interface ProdutoController {
    fun listarProdutos(): List<ProdutoDTO>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDTO>

    fun cadastrarProduto(
        categoriaId: UUID,
        descricao: String?,
        nome: String?,
        preco: Double?
    ): ProdutoDTO

    fun atualizaProduto(
        id: UUID,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): ProdutoDTO

    fun deletarProdutoPeloId(produtoId: UUID)

}
