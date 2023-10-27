package br.com.fiap.lanchonetefilura.adapter.driven.infra.repository

import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProdutoRepository : JpaRepository<ProdutoModel, UUID> {

    fun findAllByCategoriaId(id: Int): ArrayList<ProdutoModel> {
        return findAllByCategoriaId(id)
    }
}
