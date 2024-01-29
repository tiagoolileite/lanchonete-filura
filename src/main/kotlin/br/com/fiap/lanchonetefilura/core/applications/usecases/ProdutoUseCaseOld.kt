package br.com.fiap.lanchonetefilura.core.applications.usecases

import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import java.util.*

interface ProdutoUseCaseOld {

    fun getProdutos(): List<ProdutoModel>?

    fun getProdutosByCategoria(categoriaId: UUID): List<ProdutoModel>?

    //fun saveProduto(produtoRequest: ProdutoRequest): ProdutoModel?

    //fun updateProduto(produtoRequest: ProdutoRequest, produtoId: UUID): ProdutoModel?

    fun deleteProduto(id: UUID)
}