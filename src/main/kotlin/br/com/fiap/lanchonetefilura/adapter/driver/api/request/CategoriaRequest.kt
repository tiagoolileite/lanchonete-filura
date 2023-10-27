package br.com.fiap.lanchonetefilura.adapter.driver.api.request

import jakarta.validation.constraints.NotEmpty

class CategoriaRequest {
    @NotEmpty(message = "nome não pode estar vazio")
    var descricao: String? = null
}
