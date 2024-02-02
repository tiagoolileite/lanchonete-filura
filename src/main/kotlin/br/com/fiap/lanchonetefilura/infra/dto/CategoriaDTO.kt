package br.com.fiap.lanchonetefilura.infra.dto

import java.util.*

interface CategoriaDTO {
    var id: UUID

    val descricao: String?
}