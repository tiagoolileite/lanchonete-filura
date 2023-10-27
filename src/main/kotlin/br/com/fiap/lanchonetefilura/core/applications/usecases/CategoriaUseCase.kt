package br.com.fiap.lanchonetefilura.core.applications.usecases

import br.com.fiap.lanchonetefilura.adapter.driver.api.request.CategoriaRequest
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel

interface CategoriaUseCase {
    fun findById(id: Int): CategoriaModel?

    fun findAll(): ArrayList<CategoriaModel>?

    fun save(categoria: CategoriaRequest): CategoriaModel?
}
