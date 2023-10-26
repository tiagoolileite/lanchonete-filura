package br.com.fiap.lanchonetefilura.core.applications.usecases.implementateion

import br.com.fiap.lanchonetefilura.adapter.driver.api.converters.converterClienterequestToClienteModel
import br.com.fiap.lanchonetefilura.adapter.driver.api.converters.converterFindAllClientesToArrayList
import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ClienteRequest
import br.com.fiap.lanchonetefilura.core.applications.usecases.ClienteUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.adapter.driver.api.exception.cliente.ClienteJaExisteException
import br.com.fiap.lanchonetefilura.adapter.driver.api.exception.cliente.ClienteNaoEncontradoException
import br.com.fiap.lanchonetefilura.adapter.driver.api.shared.ApiHelper.logger
import org.springframework.stereotype.Component

@Component
class ClienteUseCaseImpl (private val repository: ClienteRepository) : ClienteUseCase {
    override fun findAllClientes(): ArrayList<ClienteModel> {
        val response = repository.findAll()

        return converterFindAllClientesToArrayList(response)
    }

    override fun findClienteByCpf(cpf: String): ClienteModel? {

        val response = repository.findClienteByCpf(cpf)

        response?.let {} ?: throw ClienteNaoEncontradoException()

        return response
    }

    override fun saveCliente(clienteRequest: ClienteRequest): ClienteModel {

        var cliente: ClienteModel?

        clienteRequest.cpf.let { cpf ->
            cliente = repository.findClienteByCpf(cpf)
        }

        cliente?.let {
            logger.error("Cliente Já Cadastrado")
            throw ClienteJaExisteException(it)
        }

        return repository.save(converterClienterequestToClienteModel(clienteRequest))
    }
}