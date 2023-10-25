package br.com.fiap.lanchonetefilura.core.applications.usecases

import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ClienteRequest
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel

interface ClienteUseCase {
    fun findAllClientes(): ArrayList<ClienteModel>

    fun saveCliente(clienteRequest: ClienteRequest): ClienteModel
}