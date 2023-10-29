package br.com.fiap.lanchonetefilura.core.applications.repository

import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import java.util.UUID

interface ProdutoRepository {

    fun getProdutos(): List<ProdutoModel>?

    fun getProdutoById(id: UUID): ProdutoModel?

    fun getProdutosByCategoria(categoriaId: UUID): List<ProdutoModel>?

    fun saveProduto(produtoModel: ProdutoModel): ProdutoModel?

    fun updateProduto(produtoModel: ProdutoModel): ProdutoModel?

    fun deleteProduto(id: UUID)
}