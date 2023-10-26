package br.com.fiap.lanchonetefilura.adapter.driver.api.exception.produto

import jakarta.persistence.EntityNotFoundException

class ProdutoNaoEncontradoException : EntityNotFoundException() {
    override val message: String
        get() = "Produto não foi localizado!"
}
