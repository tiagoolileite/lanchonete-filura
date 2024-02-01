package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.domain.dto.impl.ProdutoDTO
import java.util.*

interface ProdutoUseCase {
    fun listarProdutos(): List<ProdutoDTO>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDTO>

    fun cadastrarProduto(categoria: CategoriaDTOImpl, descricao: String?, nome: String?, preco: Double?): ProdutoDTO

    fun buscarProdutoPeloId(id: UUID): ProdutoDTO?

    fun atualizarProduto(
        produtoDTO: ProdutoDTO,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): ProdutoDTO

    fun deletarProdutoPeloId(id: UUID)

    fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): List<ProdutoDTO>
}
