package br.com.fiap.lanchonetefilura.core.applications.usecases

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.request.CategoriaRequestOld
import java.util.UUID

interface CategoriaUseCase {
    fun getCategorias(): List<CategoriaModel>?

    fun getCategoriaById(id: UUID): CategoriaModel?

    fun getCategoriaByDescricao(descricao: String): CategoriaModel?
}
