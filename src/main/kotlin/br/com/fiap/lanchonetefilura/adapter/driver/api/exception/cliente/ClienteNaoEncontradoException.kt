package br.com.fiap.lanchonetefilura.adapter.driver.api.exception.cliente

import jakarta.persistence.EntityNotFoundException

class ClienteNaoEncontradoException() : EntityNotFoundException() {
    override val message: String
        get() = "Cliente não foi localizado!"
}
