package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import java.util.*

interface ProdutoUseCase {
    fun listarProdutos(): List<ProdutoDomainDTO>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDomainDTO>

    fun cadastrarProduto(categoriaId: UUID, descricao: String?, nome: String?, preco: Double?): ProdutoDomainDTO

    fun buscarProdutoPeloId(id: UUID): ProdutoDomainDTO

    fun atualizarProduto(
        produtoId: UUID,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): ProdutoDomainDTO

    fun deletarProdutoPeloId(produtoId: UUID)

    fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): List<ProdutoDomainDTO>
}
