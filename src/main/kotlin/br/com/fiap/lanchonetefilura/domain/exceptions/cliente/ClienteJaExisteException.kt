package br.com.fiap.lanchonetefilura.domain.exceptions.cliente

import jakarta.persistence.EntityExistsException

class ClienteJaExisteException(cliente: ClienteModel? = null) : EntityExistsException() {
    override val message: String
        get() = "Esse Cliente Já Existe!"

    val entity: ClienteModel? = cliente
}
