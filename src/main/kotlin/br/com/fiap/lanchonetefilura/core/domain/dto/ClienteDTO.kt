package br.com.fiap.lanchonetefilura.core.domain.dto

import java.util.UUID

interface ClienteDTO {
    val id: UUID?
    val cpf: String?
    val nome: String?
    val email: String?
}