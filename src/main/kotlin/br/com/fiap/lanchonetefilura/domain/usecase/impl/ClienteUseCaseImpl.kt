package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.gateway.ClienteGateway
import br.com.fiap.lanchonetefilura.domain.usecase.ClienteUseCase
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import org.springframework.stereotype.Component

@Component
class ClienteUseCaseImpl(val gateway: ClienteGateway) : ClienteUseCase {

    override fun listarClientes(): List<ClienteDTO> {
        return gateway.listarClientes()
    }

    override fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDTO {
        return gateway.cadastrarCliente(
            email, nome, cpf
        )
    }

    override fun buscarClientePeloCpf(cpf: String): ClienteDTO {

        val cliente: ClienteDTO = gateway.buscarClientePeloCpf(cpf) ?:
        throw Exception("Cliente näo foi localizado")

        return cliente
    }
}