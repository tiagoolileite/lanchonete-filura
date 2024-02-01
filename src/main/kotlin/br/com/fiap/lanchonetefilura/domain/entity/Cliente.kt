package br.com.fiap.lanchonetefilura.domain.entity

import java.util.UUID

data class Cliente(
    val id : UUID?,
    val cpf : String?,
    val nome : String?,
    val email : String?
)
