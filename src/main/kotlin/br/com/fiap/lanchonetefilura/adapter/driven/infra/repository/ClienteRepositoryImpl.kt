package br.com.fiap.lanchonetefilura.adapter.driven.infra.repository

import br.com.fiap.lanchonetefilura.adapter.driver.api.input.ClienteInput
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.repository.ClienteRepository
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList

@Service
class ClienteRepositoryImpl : ClienteRepository {
    override fun getClientes(): ArrayList<ClienteModel> {

        return arrayListOf(
            ClienteModel(nome = "Tiago", cpf = "123456", email = "email1@email.com.br"),
            ClienteModel(),
            ClienteModel(nome = "Leite", cpf = "234567")
        )
    }

    override fun createCliente(clienteInput: ClienteInput): ClienteModel {
        return ClienteModel(
            nome = clienteInput.nome,
            cpf = clienteInput.cpf,
            email = clienteInput.email
        )
    }
}