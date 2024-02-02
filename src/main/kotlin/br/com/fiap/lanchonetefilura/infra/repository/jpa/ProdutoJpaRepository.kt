package br.com.fiap.lanchonetefilura.infra.repository.jpa

import br.com.fiap.lanchonetefilura.infra.dto.impl.ProdutoDTOImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProdutoJpaRepository : JpaRepository<ProdutoDTOImpl, UUID> {

    fun findAllByCategoriaId(id: UUID): ArrayList<ProdutoDTOImpl>
}
