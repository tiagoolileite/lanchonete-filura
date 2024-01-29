package br.com.fiap.lanchonetefilura.core.applications.usecases

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import java.util.UUID

interface CategoriaUseCaseOld {
    fun getCategorias(): List<CategoriaModel>?

    fun getCategoriaById(id: UUID): CategoriaModel?

    fun getCategoriaByDescricao(descricao: String): CategoriaModel?
}
