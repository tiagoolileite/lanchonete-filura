package br.com.fiap.lanchonetefilura.adapter.driver.api.response

import java.util.*

data class ClienteResponse (
    val id: UUID?,
    val cpf: String?,
    val nome: String?,
    val email: String?
)