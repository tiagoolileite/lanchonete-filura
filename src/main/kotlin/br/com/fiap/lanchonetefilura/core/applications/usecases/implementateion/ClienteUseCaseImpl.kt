package br.com.fiap.lanchonetefilura.core.applications.usecases.implementateion

import br.com.fiap.lanchonetefilura.adapter.driver.api.input.ClienteInput
import br.com.fiap.lanchonetefilura.core.applications.usecases.ClienteUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.repository.ClienteRepository
import org.springframework.stereotype.Component

@Component
class ClienteUseCaseImpl (private val repository: ClienteRepository) : ClienteUseCase {
    override fun getClientes(): ArrayList<ClienteModel> {

        return repository.getClientes()
    }

    override fun createCliente(clienteInput: ClienteInput): ClienteModel {

        return repository.createCliente(clienteInput)
    }
}