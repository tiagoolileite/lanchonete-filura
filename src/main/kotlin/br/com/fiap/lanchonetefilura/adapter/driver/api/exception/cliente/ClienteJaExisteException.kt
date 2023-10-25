package br.com.fiap.lanchonetefilura.adapter.driver.api.exception.cliente

import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import jakarta.persistence.EntityExistsException

class ClienteJaExisteException(cliente: ClienteModel? = null) : EntityExistsException() {
    override val message: String
        get() = "Esse Cliente Já Existe!"

    val entity: ClienteModel? = cliente
}
