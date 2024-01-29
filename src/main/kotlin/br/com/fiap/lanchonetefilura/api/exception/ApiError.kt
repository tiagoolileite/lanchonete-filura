package br.com.fiap.lanchonetefilura.api.exception

data class ApiError(val status: Int? = null, val message: String? = null, val entity: Any? = null)