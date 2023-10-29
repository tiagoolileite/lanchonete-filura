package br.com.fiap.lanchonetefilura.core.applications.repository

import br.com.fiap.lanchonetefilura.core.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.core.domain.request.CategoriaRequest
import java.util.UUID

interface CategoriaRepository {

    fun getCategorias(): List<CategoriaDTO>?

    fun getCategoriaById(id: UUID): CategoriaDTO?

    fun getCategoriaByDescricao(descricao: String): CategoriaDTO?

    fun saveCategoria(categoriaRequest: CategoriaRequest): CategoriaDTO?
}