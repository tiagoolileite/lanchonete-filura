package br.com.fiap.lanchonetefilura.core.exceptions.cliente

import jakarta.persistence.EntityNotFoundException

class ClienteNaoEncontradoException() : EntityNotFoundException() {
    override val message: String
        get() = "Cliente não foi localizado!"
}
