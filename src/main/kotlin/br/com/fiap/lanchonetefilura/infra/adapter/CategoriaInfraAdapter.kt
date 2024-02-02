package br.com.fiap.lanchonetefilura.infra.adapter

import br.com.fiap.lanchonetefilura.infra.dto.impl.CategoriaDTOImpl
import java.util.*

interface CategoriaInfraAdapter {
    fun initCategoriaDTO(id: UUID?, descricao: String?): CategoriaDTOImpl
}