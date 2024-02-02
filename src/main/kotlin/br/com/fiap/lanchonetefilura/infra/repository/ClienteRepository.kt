package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import java.util.*

interface ClienteRepository {

    fun listarClientes(): List<ClienteDTO>

    fun cadastrarCliente(clienteDomainDTO : ClienteDomainDTO): ClienteDTO

    fun buscarClientePeloCpf(cpf: String): ClienteDTO?

    fun buscarClientePeloId(clienteId: UUID): Optional<ClienteDTO>
}