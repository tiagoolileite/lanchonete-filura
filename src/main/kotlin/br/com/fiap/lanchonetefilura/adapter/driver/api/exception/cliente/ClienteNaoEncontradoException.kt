package br.com.fiap.lanchonetefilura.adapter.driver.api.exception.cliente

import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import jakarta.persistence.EntityExistsException
import jakarta.persistence.EntityNotFoundException

class ClienteNaoEncontradoException() : EntityNotFoundException() {
    override val message: String
        get() = "Cliente não foi localizado!"
}
