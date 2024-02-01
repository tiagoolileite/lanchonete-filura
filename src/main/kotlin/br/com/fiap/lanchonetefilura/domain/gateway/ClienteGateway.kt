package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import java.util.*

interface ClienteGateway {
    fun listarClientes(): List<ClienteDTOImpl>

    fun cadastrarCliente(clienteDomainDTO : ClienteDomainDTO): ClienteDTOImpl

    fun buscarClientePeloCpf(cpf: String): ClienteDTOImpl?

    fun buscarClientePeloId(clienteId: UUID): Optional<ClienteDTOImpl>
}
