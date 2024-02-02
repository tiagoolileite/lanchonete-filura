package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.entity.Produto
import java.util.*

interface ProdutoUseCase {
    fun listarProdutos(): List<Produto>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<Produto>

    fun cadastrarProduto(categoriaId: UUID, descricao: String, nome: String, preco: Double): Produto

    fun buscarProdutoPeloId(id: UUID): Produto

    fun atualizarProduto(
        produtoId: UUID,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): Produto

    fun deletarProdutoPeloId(produtoId: UUID)

    fun listarProdutosPorListaDeIds(produtosId: List<UUID>): List<Produto>
}
