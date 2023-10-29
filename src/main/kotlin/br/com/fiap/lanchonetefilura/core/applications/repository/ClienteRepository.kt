package br.com.fiap.lanchonetefilura.core.applications.repository

import br.com.fiap.lanchonetefilura.core.domain.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest

interface ClienteRepository {

    fun getClientes(): List<ClienteDTO>?

    fun getClienteByCpf(cpf: String): ClienteDTO?

    fun saveCliente(clienteRequest: ClienteRequest): ClienteDTO?
}