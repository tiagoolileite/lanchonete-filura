package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.domain.exceptions.cliente.ClienteNaoEncontradoException
import br.com.fiap.lanchonetefilura.domain.gateway.ClienteGateway
import br.com.fiap.lanchonetefilura.domain.usecase.ClienteUseCase
import org.springframework.stereotype.Component
import java.util.*

@Component
class ClienteUseCaseImpl(
    val gateway: ClienteGateway
) : ClienteUseCase {

    override fun listarClientes(): List<Cliente> {

        return gateway.listarClientes()
    }

    override fun cadastrarCliente(
        cpf: String?, nome: String?, email: String?
    ): Cliente {

        val cliente = Cliente(
            cpf = cpf,
            nome = nome,
            email = email
        )

        return gateway.cadastrarCliente(cliente)
    }

    override fun buscarClientePeloCpf(cpf: String): Cliente {

        val cliente = gateway.buscarClientePeloCpf(cpf)

        return cliente ?: throw ClienteNaoEncontradoException()
    }

    override fun buscarClientePeloId(clienteId: UUID): Cliente? {

        val cliente: Optional<Cliente> =
            gateway.buscarClientePeloId(clienteId = clienteId)

        if (cliente.isEmpty) {
            throw ClienteNaoEncontradoException()
        }

        return cliente.get()
    }
}