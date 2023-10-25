package br.com.fiap.lanchonetefilura.adapter.driver.api.request

data class ClienteRequest (
    val cpf: String? = null,
    val nome: String? = null,
    val email: String? = null
)