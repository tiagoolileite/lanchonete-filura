package br.com.fiap.lanchonetefilura.adapter.driver.api.response

import java.util.UUID

data class ClienteResponse (
    val id: UUID?,
    val cpf: String?,
    val nome: String?,
    val email: String?
)