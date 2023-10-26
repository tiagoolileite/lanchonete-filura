package br.com.fiap.lanchonetefilura.core.applications.usecases.implementateion

import br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.CategoriaRepository
import br.com.fiap.lanchonetefilura.core.applications.usecases.CategoriaUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import org.springframework.stereotype.Component

@Component
class CategoriaUseCaseImpl (
    private val categoriaRepository: CategoriaRepository
) : CategoriaUseCase {
    override fun findById(id: Int): CategoriaModel? {

        return categoriaRepository.findById(id).get()
    }
}