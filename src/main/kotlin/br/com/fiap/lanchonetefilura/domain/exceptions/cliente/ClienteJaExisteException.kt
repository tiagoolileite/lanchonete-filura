package br.com.fiap.lanchonetefilura.domain.exceptions.cliente

import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import jakarta.persistence.EntityExistsException

class ClienteJaExisteException(cliente: ClienteDTO? = null) : EntityExistsException() {
    override val message: String
        get() = "Esse Cliente Já Existe!"

    val entity: ClienteDTO? = cliente
}
