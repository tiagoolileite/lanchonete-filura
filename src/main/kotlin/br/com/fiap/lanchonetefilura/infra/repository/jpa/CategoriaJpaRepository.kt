package br.com.fiap.lanchonetefilura.infra.repository.jpa

import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CategoriaJpaRepository : JpaRepository<CategoriaDTO, UUID> {

    fun findCategoriaById(id: UUID): CategoriaDTO

    fun findCategoriaByDescricao(descricao: String): CategoriaDTO
}
