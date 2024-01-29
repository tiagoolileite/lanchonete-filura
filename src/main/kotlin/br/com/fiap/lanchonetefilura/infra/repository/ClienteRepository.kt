package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest
import java.util.*

interface ClienteRepository {

    fun getClientes(): List<ClienteModel>?

    fun getClienteByCpf(cpf: String): ClienteModel?

    fun getClienteById(id: UUID): ClienteModel?

    fun saveCliente(clienteRequest: ClienteRequest): ClienteModel?
}