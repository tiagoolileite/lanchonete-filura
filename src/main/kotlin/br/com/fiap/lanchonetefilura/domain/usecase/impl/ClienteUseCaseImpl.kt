package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDTO
import br.com.fiap.lanchonetefilura.domain.gateway.ClienteGateway
import br.com.fiap.lanchonetefilura.domain.usecase.ClienteUseCase
import org.springframework.stereotype.Component
import java.util.*

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

        return gateway.buscarClientePeloCpf(cpf) ?: throw Exception("Cliente näo foi localizado")
    }

    override fun buscarClientePeloId(clienteId: UUID): ClienteDTO? {

        val cliente: Optional<ClienteDTO> = gateway.buscarClientePeloId(clienteId)

        if (cliente.isEmpty)
            throw Exception("Cliente näo foi localizado")

        return cliente.get()
    }
}