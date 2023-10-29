package br.com.fiap.lanchonetefilura.core.exceptions.produto

import jakarta.persistence.EntityNotFoundException

class ProdutoNaoEncontradoException : EntityNotFoundException() {
    override val message: String
        get() = "Produto não foi localizado!"
}
