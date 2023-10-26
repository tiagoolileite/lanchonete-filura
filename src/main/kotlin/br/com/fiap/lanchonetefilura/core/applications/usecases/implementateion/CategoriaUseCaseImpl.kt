package br.com.fiap.lanchonetefilura.core.applications.usecases.implementateion

import br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.CategoriaRepository
import br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.ProdutoRepository
import br.com.fiap.lanchonetefilura.adapter.driver.api.converters.converterProdutorequestToProdutoModel
import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ProdutoRequest
import br.com.fiap.lanchonetefilura.core.applications.usecases.CategoriaUseCase
import br.com.fiap.lanchonetefilura.core.applications.usecases.ProdutoUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CategoriaUseCaseImpl (
    private val categoriaRepository: CategoriaRepository
) : CategoriaUseCase {
    override fun findById(id: Int): CategoriaModel? {

        return categoriaRepository.findById(id).get()
    }
}