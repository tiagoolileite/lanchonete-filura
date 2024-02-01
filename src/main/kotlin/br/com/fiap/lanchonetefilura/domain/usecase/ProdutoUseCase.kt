package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDTO
import java.util.*

interface ProdutoUseCase {
    fun listarProdutos(): List<ProdutoDTO>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDTO>

    fun cadastrarProduto(categoriaId: UUID, descricao: String?, nome: String?, preco: Double?): ProdutoDTO

    fun buscarProdutoPeloId(id: UUID): ProdutoDTO

    fun atualizarProduto(
        produtoId: UUID,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): ProdutoDTO

    fun deletarProdutoPeloId(produtoId: UUID)

    fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): List<ProdutoDTO>
}
