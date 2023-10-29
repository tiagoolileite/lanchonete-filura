package br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.impl

import br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.ProdutoJpaRepository
import br.com.fiap.lanchonetefilura.core.applications.repository.ProdutoRepository
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ProdutoRepositoryImpl(private val repository: ProdutoJpaRepository) : ProdutoRepository {
    override fun getProdutos(): List<ProdutoModel>? {

        return repository.findAll()
    }

    override fun getProdutoById(id: UUID): ProdutoModel? {

        return repository.findById(id).get()
    }

    override fun getProdutosByCategoria(categoriaId: UUID): List<ProdutoModel>? {

        return repository.findAllByCategoriaId(id = categoriaId)
    }

    override fun saveProduto(produtoModel: ProdutoModel): ProdutoModel? {

        return repository.save(produtoModel)
    }

    override fun updateProduto(
        produtoModel: ProdutoModel
    ): ProdutoModel? {

        return repository.save(produtoModel)
    }

    override fun deleteProduto(id: UUID) {

        return repository.deleteById(id)
    }
}