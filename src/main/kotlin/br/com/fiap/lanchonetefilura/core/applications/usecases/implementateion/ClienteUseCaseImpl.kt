package br.com.fiap.lanchonetefilura.core.applications.usecases.implementateion

import br.com.fiap.lanchonetefilura.core.applications.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.core.applications.usecases.ClienteUseCase
import br.com.fiap.lanchonetefilura.core.domain.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest
import br.com.fiap.lanchonetefilura.core.exceptions.cliente.ClienteJaExisteException
import br.com.fiap.lanchonetefilura.core.exceptions.cliente.ClienteNaoEncontradoException
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import org.springframework.stereotype.Component

@Component
class ClienteUseCaseImpl (private val repository: ClienteRepository) : ClienteUseCase {
    override fun getClientes(): List<ClienteDTO>? {

        return repository.getClientes()
    }

    override fun getClienteByCpf(cpf: String): ClienteDTO? {

        val cliente: ClienteDTO? = repository.getClienteByCpf(cpf = cpf)

        cliente?.let {} ?: throw ClienteNaoEncontradoException()

        return cliente
    }

    override fun saveCliente(clienteRequest: ClienteRequest): ClienteDTO? {

        val clienteByCpf: ClienteDTO? = repository.getClienteByCpf(cpf = clienteRequest.cpf)

        clienteByCpf?.let {
            logger.error("Cliente já estava cadastrado na base")
            throw ClienteJaExisteException(it)
        }

        return repository.saveCliente(clienteRequest)
    }
}