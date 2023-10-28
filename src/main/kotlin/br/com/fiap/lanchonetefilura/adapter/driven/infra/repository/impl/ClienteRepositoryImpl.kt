package br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.impl

import br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.ClienteJpaRepository
import br.com.fiap.lanchonetefilura.adapter.driver.api.extensions.converterClienteRequestToClienteDTO
import br.com.fiap.lanchonetefilura.core.applications.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.core.domain.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest
import org.springframework.stereotype.Repository

@Repository
class ClienteRepositoryImpl(private val repository: ClienteJpaRepository) : ClienteRepository {
    override fun getClientes(): List<ClienteDTO>? {
        return repository.findAll()
    }

    override fun getClienteByCpf(cpf: String): ClienteDTO? {
        return repository.findClienteByCpf(cpf = cpf)
    }

    override fun saveCliente(clienteRequest: ClienteRequest): ClienteModel? {

        val cliente = clienteRequest.converterClienteRequestToClienteDTO()

        return repository.save(cliente)
    }
}