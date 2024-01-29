package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import java.util.*

interface ProdutoController {
    fun listarProdutos(): List<ProdutoResponse>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoResponse>

    fun cadastrarProduto(
        categoriaId: UUID?,
        descricao: String?,
        nome: String?,
        preco: Double?
    ): ProdutoResponse

    fun atualizaProduto(
        id: UUID,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): ProdutoResponse?

    fun deletarProdutoPeloId(id: UUID)

}
