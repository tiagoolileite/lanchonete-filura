package br.com.fiap.lanchonetefilura.core.applications.usecases.implementateion

import br.com.fiap.lanchonetefilura.adapter.driven.infra.extensions.converterProdutoRequestToProdutoModel
import br.com.fiap.lanchonetefilura.core.applications.repository.CategoriaRepository
import br.com.fiap.lanchonetefilura.core.applications.repository.ProdutoRepository
import br.com.fiap.lanchonetefilura.core.applications.usecases.ProdutoUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import br.com.fiap.lanchonetefilura.core.domain.request.ProdutoRequest
import br.com.fiap.lanchonetefilura.core.exceptions.categoria.CategoriaInvalidaException
import br.com.fiap.lanchonetefilura.core.exceptions.produto.ProdutoNaoDeletadoException
import br.com.fiap.lanchonetefilura.core.exceptions.produto.ProdutoNaoEncontradoException
import br.com.fiap.lanchonetefilura.core.extensions.editCategoriaModel
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoUseCaseImpl (
    private val produtoRepository: ProdutoRepository,
    private val categoriaRepository: CategoriaRepository
) : ProdutoUseCase {

    override fun getProdutos(): List<ProdutoModel>? {

        return  produtoRepository.getProdutos()
    }

    override fun getProdutosByCategoria(categoriaId: UUID): List<ProdutoModel>? {

        return produtoRepository.getProdutosByCategoria(categoriaId = categoriaId)
    }

    override fun saveProduto(produtoRequest: ProdutoRequest): ProdutoModel? {

        val categoriaModel = produtoRequest.categoriaId.let { categoriaRepository.getCategoriaById(it) }

        categoriaModel?.let {} ?: throw CategoriaInvalidaException()

        val produto = produtoRequest.converterProdutoRequestToProdutoModel(categoriaModel = categoriaModel)

        val produtoModel = produto.editCategoriaModel(categoriaModel)

        return produtoRepository.saveProduto(produtoModel = produtoModel)
    }

    override fun updateProduto(produtoRequest: ProdutoRequest, produtoId: UUID): ProdutoModel? {

        val produto = produtoRepository.getProdutoById(produtoId)

        produto?.let {} ?: throw ProdutoNaoEncontradoException()

        val categoriaModel = produtoRequest.categoriaId.let { categoriaRepository.getCategoriaById(it) }

        categoriaModel?.let {} ?: throw CategoriaInvalidaException()

        val produtoModel = produto.editCategoriaModel(categoriaModel)

        return produtoRepository.updateProduto(produtoModel = produtoModel)
    }

    override fun deleteProduto(id: UUID) {
        val produto = produtoRepository.getProdutoById(id)

        produto?.let {} ?: throw ProdutoNaoEncontradoException()

        try {
            produtoRepository.deleteProduto(id = id)
        } catch (ex: Exception) { throw ProdutoNaoDeletadoException() }
    }

}