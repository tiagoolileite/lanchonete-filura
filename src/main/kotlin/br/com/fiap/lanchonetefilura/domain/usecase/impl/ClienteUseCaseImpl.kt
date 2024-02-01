package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.adapter.ClienteAdapter
import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.domain.gateway.ClienteGateway
import br.com.fiap.lanchonetefilura.domain.usecase.ClienteUseCase
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.stereotype.Component
import java.util.*

@Component
class ClienteUseCaseImpl(
    val gateway: ClienteGateway,
    val adapter: ClienteAdapter
) : ClienteUseCase {

    override fun listarClientes(): List<ClienteDomainDTO> {
        return gateway.listarClientes()
    }

    override fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDomainDTO {

        val cliente = Cliente(
            cpf = cpf,
            nome = nome,
            email = email
        )

        val clienteDomainDTO: ClienteDomainDTO =
            adapter.adaptarClienteParaClienteDomainDto(cliente = cliente)

        return gateway.cadastrarCliente(clienteDomainDTO = clienteDomainDTO)
    }

    override fun buscarClientePeloCpf(cpf: String): ClienteDomainDTO {
        return gateway.buscarClientePeloCpf(cpf) ?: also {
            "${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: " +
                    "Cliente não foi localizado"
        }.run { throw Exception("Cliente näo foi localizado") }
    }

    override fun buscarClientePeloId(clienteId: UUID): ClienteDomainDTO? {

        val clienteOptionalDomainDTO: Optional<ClienteDomainDTO> =
            gateway.buscarClientePeloId(clienteId = clienteId)

        if (clienteOptionalDomainDTO.isEmpty) {
            "${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: " +
                    "Cliente não foi localizado"
            throw Exception("Cliente näo foi localizado")
        }

        return clienteOptionalDomainDTO.get()
    }
}