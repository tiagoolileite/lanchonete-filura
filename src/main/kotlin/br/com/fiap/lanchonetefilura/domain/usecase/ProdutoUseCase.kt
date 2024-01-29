package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import java.util.*

interface ProdutoUseCase {
    fun listarProdutos(): List<ProdutoDTO>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDTO>

    fun cadastrarProduto(categoria: CategoriaDTO, descricao: String?, nome: String?, preco: Double?): ProdutoDTO

    fun buscarProdutoPeloId(id: UUID): ProdutoDTO?

    fun atualizarProduto(
        produtoDTO: ProdutoDTO,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): ProdutoDTO

    fun deletarProdutoPeloId(id: UUID)
}
