package br.com.fiap.lanchonetefilura.infra.dto

import br.com.fiap.lanchonetefilura.infra.dto.impl.CategoriaDTOImpl
import java.util.*

interface CategoriaDTO {
    var id: UUID

    val descricao: String?
}