package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.adapter.ClienteAdapter
import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.domain.gateway.ClienteGateway
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.infra.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.stereotype.Component
import java.util.*

@Component
class ClienteGatewayImpl(
    val repository: ClienteRepository,
    val adapter: ClienteAdapter
) : ClienteGateway {

    override fun listarClientes(): List<ClienteDomainDTO> {

        val clientesDTO: List<ClienteDTO> = repository.listarClientes()

        return adapter.adaptarClientesDtoParaDomainDto(clientesDTO = clientesDTO)
    }

    override fun cadastrarCliente(clienteDomainDTO : ClienteDomainDTO): ClienteDomainDTO {

        val clienteDTO: ClienteDTO =
            repository.cadastrarCliente(clienteDomainDTO = clienteDomainDTO)

        return adapter.adaptarClienteDtoParaDomainDto(clienteDTO = clienteDTO)
    }

    override fun buscarClientePeloCpf(cpf: String): ClienteDomainDTO? {

        val clienteDTO: ClienteDTO? =
            repository.buscarClientePeloCpf(cpf = cpf)

        return clienteDTO?.let { adapter.adaptarClienteDtoParaDomainDto(it) } ?: also {
            "${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: " +
                    "Falha ao consultar cliente pelo CPF"
        }.run { throw Exception("Falha ao consultar cliente pelo CPF") }
    }

    override fun buscarClientePeloId(clienteId: UUID): Optional<ClienteDomainDTO> {

        val clienteDTO: Optional<ClienteDTO> =
            repository.buscarClientePeloId(clienteId = clienteId)

        if (clienteDTO.isEmpty) {
            "${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: " +
                    "Falha ao consultar cliente pelo CPF"
            throw Exception("Falha ao consultar cliente pelo CPF")
        }

        return Optional.of(adapter.adaptarClienteDtoParaDomainDto(clienteDTO = clienteDTO.get()))
    }
}