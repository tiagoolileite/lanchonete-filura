package br.com.fiap.lanchonetefilura.domain.exceptions.cliente

import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import jakarta.persistence.EntityExistsException

class ClienteJaExisteException(cliente: Cliente? = null) : EntityExistsException() {
    override val message: String
        get() = "Esse Cliente Já Existe!"

    val entity: Cliente? = cliente
}
