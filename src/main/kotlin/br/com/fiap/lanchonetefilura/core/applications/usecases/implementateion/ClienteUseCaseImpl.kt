package br.com.fiap.lanchonetefilura.core.applications.usecases.implementateion

import br.com.fiap.lanchonetefilura.core.applications.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.core.applications.usecases.ClienteUseCase
import br.com.fiap.lanchonetefilura.core.domain.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest
import org.springframework.stereotype.Component

@Component
class ClienteUseCaseImpl (private val repository: ClienteRepository) : ClienteUseCase {
    override fun getClientes(): List<ClienteDTO>? {

        return repository.getClientes()
    }

    override fun getClienteByCpf(cpf: String): ClienteDTO? {

        /* TODO response?.let {} ?: throw ClienteNaoEncontradoException() */

        return repository.getClienteByCpf(cpf = cpf)
    }

    override fun saveCliente(clienteRequest: ClienteRequest): ClienteDTO? {

        val cliente: ClienteDTO? = repository.getClienteByCpf(clienteRequest.cpf)

        /* TODO cliente?.let {
            logger.error("Cliente Já Cadastrado")
            throw ClienteJaExisteException(it)
        }*/

        return repository.saveCliente(clienteRequest)
    }
}