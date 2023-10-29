package br.com.fiap.lanchonetefilura.core.applications.usecases

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.request.CategoriaRequest
import java.util.UUID

interface CategoriaUseCase {
    fun getCategorias(): List<CategoriaModel>?

    fun getCategoriaById(id: UUID): CategoriaModel?

    fun getCategoriaByDescricao(descricao: String): CategoriaModel?

    fun saveCategoria(categoriaRequest: CategoriaRequest): CategoriaModel?
}
