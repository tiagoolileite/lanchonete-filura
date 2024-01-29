package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.gateway.ClienteGateway
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.infra.repository.ClienteRepository
import org.springframework.stereotype.Component

@Component
class ClienteGatewayImpl(val repository: ClienteRepository) : ClienteGateway {

    override fun listarClientes(): List<ClienteDTO> {
        return repository.listarClientes()
    }

    override fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDTO {
        return repository.cadastrarCliente(
            email, nome, cpf
        )
    }

    override fun buscarClientePeloCpf(cpf: String): ClienteDTO? {
        return repository.buscarClientePeloCpf(cpf)
    }
}