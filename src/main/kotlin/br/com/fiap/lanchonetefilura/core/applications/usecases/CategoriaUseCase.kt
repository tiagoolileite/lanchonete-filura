package br.com.fiap.lanchonetefilura.core.applications.usecases

import br.com.fiap.lanchonetefilura.adapter.driver.api.request.CategoriaRequest
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import java.util.UUID
import kotlin.collections.ArrayList

interface CategoriaUseCase {
    fun findById(id: UUID): CategoriaModel?

    fun findAll(): ArrayList<CategoriaModel>?

    fun save(categoria: CategoriaRequest): CategoriaModel?
}
