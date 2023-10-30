package br.com.fiap.lanchonetefilura.core.applications.usecases

import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest

interface ClienteUseCase {
    fun getClientes(): List<ClienteModel>?

    fun getClienteByCpf(cpf: String): ClienteModel?

    fun saveCliente(clienteRequest: ClienteRequest): ClienteModel?
}