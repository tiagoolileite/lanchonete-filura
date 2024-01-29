package br.com.fiap.lanchonetefilura.domain.exceptions.cliente

import jakarta.persistence.EntityNotFoundException

class ClienteNaoEncontradoException : EntityNotFoundException() {
    override val message: String
        get() = "Cliente não foi localizado!"
}
