package br.com.fiap.lanchonetefilura.api.model.cliente

import java.util.*

data class ClienteResponse (
    val id: UUID? = null,
    val cpf: String? = null,
    val nome: String? = null,
    val email: String? = null
)
