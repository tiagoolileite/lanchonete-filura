package br.com.fiap.lanchonetefilura.core.applications.usecases.implementateion

import br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.ProdutoRepository
import br.com.fiap.lanchonetefilura.adapter.driver.api.converters.converterFindAllProdutosToArrayList
import br.com.fiap.lanchonetefilura.adapter.driver.api.converters.converterProdutorequestToProdutoModel
import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ProdutoRequest
import br.com.fiap.lanchonetefilura.core.applications.usecases.ProdutoUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ProdutoUseCaseImpl (
    private val produtoRepository: ProdutoRepository
) : ProdutoUseCase {

    override fun findAllProdutos(): ArrayList<ProdutoModel>? {
        return converterFindAllProdutosToArrayList(produtoRepository.findAll())
    }

    override fun findProdutoById(id: UUID): ProdutoModel? {
        return produtoRepository.findById(id).get()
    }

    override fun findProdutosByCategoria(id: UUID): ArrayList<ProdutoModel>? {
        return produtoRepository.findAllByCategoriaId(id)
    }


    override fun saveProduto(produtoRequest: ProdutoRequest, categoria: CategoriaModel?): ProdutoModel {

        return produtoRepository.save(converterProdutorequestToProdutoModel(produtoRequest, categoria))
    }

    override fun updateProduto(produtoRequest: ProdutoRequest, id: UUID, categoria: CategoriaModel?): ProdutoModel? {
        val produto = produtoRepository.findById(id).get()

        atualizaProdutoComRequest(produtoRequest, produto, categoria)

        return produtoRepository.save(produto)
    }

    override fun deleteProduto(id: UUID) {
        produtoRepository.findById(id).get()

        produtoRepository.deleteById(id)
    }

    private fun atualizaProdutoComRequest(
        produtoRequest: ProdutoRequest,
        produto: ProdutoModel,
        categoria: CategoriaModel?
    ) {
        produto.nome = produtoRequest.nome
        produto.descricao = produtoRequest.descricao
        produto.preco = produtoRequest.preco
        produto.categoria = categoria
    }


}