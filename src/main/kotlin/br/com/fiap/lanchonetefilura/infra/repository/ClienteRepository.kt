package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteRequest
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import java.util.*

interface ClienteRepository {

    fun getClientes(): List<ClienteDTO>?

    fun getClienteByCpf(cpf: String): ClienteDTO?

    fun getClienteById(id: UUID): ClienteDTO?

    fun saveCliente(clienteRequest: ClienteRequest): ClienteDTO?
}