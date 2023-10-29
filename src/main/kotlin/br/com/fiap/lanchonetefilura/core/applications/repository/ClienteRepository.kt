package br.com.fiap.lanchonetefilura.core.applications.repository

import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest

interface ClienteRepository {

    fun getClientes(): List<ClienteModel>?

    fun getClienteByCpf(cpf: String): ClienteModel?

    fun saveCliente(clienteRequest: ClienteRequest): ClienteModel?
}