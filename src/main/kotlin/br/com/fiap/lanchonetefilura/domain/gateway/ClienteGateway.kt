package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import java.util.*

interface ClienteGateway {
    fun listarClientes(): List<ClienteDomainDTO>

    fun cadastrarCliente(clienteDomainDTO : ClienteDomainDTO): ClienteDomainDTO

    fun buscarClientePeloCpf(cpf: String): ClienteDomainDTO?

    fun buscarClientePeloId(clienteId: UUID): Optional<ClienteDomainDTO>
}
