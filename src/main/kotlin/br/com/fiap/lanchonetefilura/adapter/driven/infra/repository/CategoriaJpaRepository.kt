package br.com.fiap.lanchonetefilura.adapter.driven.infra.repository

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CategoriaJpaRepository : JpaRepository<CategoriaModel, UUID> {

    fun findCategoriaById(id: UUID): CategoriaModel

    fun findCategoriaByDescricao(descricao: String): CategoriaModel
}
