package br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.impl

import br.com.fiap.lanchonetefilura.adapter.driven.infra.extensions.converterClienteRequestToClienteModel
import br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.ClienteJpaRepository
import br.com.fiap.lanchonetefilura.core.applications.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import org.springframework.stereotype.Repository
import java.lang.Exception
import java.util.*

@Repository
class ClienteRepositoryImpl(private val repository: ClienteJpaRepository) : ClienteRepository {
    override fun getClientes(): List<ClienteModel>? {

        return repository.findAll()
    }

    override fun getClienteByCpf(cpf: String): ClienteModel? {

        var cliente: ClienteModel? = null

        try {
           cliente = repository.findClienteByCpf(cpf = cpf)
        } catch (ex: Exception) {
            logger.info("Cliente não localizado na base pelo cpf")
        }

        return cliente
    }

    override fun getClienteById(id: UUID): ClienteModel? {

        var cliente: ClienteModel? = null

        try {
            cliente = repository.findById(id).get()
        } catch (ex: Exception) {
            logger.info("Cliente não localizado na base pelo id")
        }

        return cliente
    }

    override fun saveCliente(clienteRequest: ClienteRequest): ClienteModel? {

        val cliente = clienteRequest.converterClienteRequestToClienteModel()

        return repository.save(cliente)
    }
}