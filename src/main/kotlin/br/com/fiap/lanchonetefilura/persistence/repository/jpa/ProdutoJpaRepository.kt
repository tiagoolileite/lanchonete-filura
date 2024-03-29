package br.com.fiap.lanchonetefilura.persistence.repository.jpa

import br.com.fiap.lanchonetefilura.persistence.dto.ProdutoDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProdutoJpaRepository : JpaRepository<ProdutoDTO, UUID> {

    fun findAllByCategoriaId(id: UUID): ArrayList<ProdutoDTO>
}
