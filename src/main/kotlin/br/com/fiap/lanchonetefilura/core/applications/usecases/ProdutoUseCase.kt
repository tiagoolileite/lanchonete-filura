package br.com.fiap.lanchonetefilura.core.applications.usecases

import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ProdutoRequest
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import java.util.UUID
import kotlin.collections.ArrayList

interface ProdutoUseCase {

    fun findProdutoById(id: UUID): ProdutoModel?

    fun findProdutosByCategoria(id: Int): ArrayList<ProdutoModel>?

    fun findAllProdutos(): ArrayList<ProdutoModel>?
    fun saveProduto(produtoRequest: ProdutoRequest, categoria: CategoriaModel?): ProdutoModel?

    fun updateProduto(produtoRequest: ProdutoRequest, id: UUID, categoria: CategoriaModel?): ProdutoModel?

    fun deleteProduto(id: UUID)
}