package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.domain.gateway.ClienteGateway
import br.com.fiap.lanchonetefilura.infra.repository.ClienteRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class ClienteGatewayImpl(
    val repository: ClienteRepository
) : ClienteGateway {

    override fun listarClientes(): List<Cliente> {

        return repository.listarClientes()
    }

    override fun cadastrarCliente(cliente : Cliente): Cliente {

        return repository.cadastrarCliente(cliente = cliente)
    }

    override fun buscarClientePeloCpf(cpf: String): Cliente? {

        return repository.buscarClientePeloCpf(cpf)
    }

    override fun buscarClientePeloId(clienteId: UUID): Optional<Cliente> {

        return repository.buscarClientePeloId(clienteId)
    }
}