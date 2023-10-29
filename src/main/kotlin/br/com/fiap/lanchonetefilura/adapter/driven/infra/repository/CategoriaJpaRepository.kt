package br.com.fiap.lanchonetefilura.adapter.driven.infra.repository

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CategoriaJpaRepository : JpaRepository<CategoriaModel, UUID> {

    fun findCategoriaById(id: UUID): CategoriaModel /*{
        return this.findCategoriaById(id = id)
    }*/

    fun findCategoriaByDescricao(descricao: String): CategoriaModel /*{
        return this.findCategoriaById(id = id)
    }*/
}
