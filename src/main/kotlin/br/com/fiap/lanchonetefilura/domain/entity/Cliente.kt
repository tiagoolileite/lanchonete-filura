package br.com.fiap.lanchonetefilura.domain.entity

import java.util.*

data class Cliente(
    var id: UUID? = UUID.randomUUID(),
    val cpf : String?,
    val nome : String?,
    val email : String?
)
