package br.com.fiap.lanchonetefilura.infra.dto

import java.util.*

interface ClienteDTO {
    val id: UUID

    val cpf: String?

    val nome: String?

    val email: String?
}
