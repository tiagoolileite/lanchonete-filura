package br.com.fiap.lanchonetefilura.adapter.driven.infra.repository

import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.repository.ClienteRepository
import org.springframework.stereotype.Service

@Service
class ClienteRepositoryImpl : ClienteRepository {
    override fun getClientes(): ArrayList<ClienteModel> {
        return arrayListOf(
            ClienteModel("Tiago", cpf = "123456", email = "email1@email.com.br"),
            ClienteModel(),
            ClienteModel("Leite", cpf = "234567")
        )
    }
}