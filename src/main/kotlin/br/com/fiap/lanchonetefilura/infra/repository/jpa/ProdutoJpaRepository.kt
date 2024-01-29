package br.com.fiap.lanchonetefilura.infra.repository.jpa

import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProdutoJpaRepository : JpaRepository<ProdutoModel, UUID> {

    fun findAllByCategoriaId(id: UUID): ArrayList<ProdutoModel>
}
