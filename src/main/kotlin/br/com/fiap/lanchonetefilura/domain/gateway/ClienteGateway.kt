package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import java.util.*

interface ClienteGateway {
    fun listarClientes(): List<ClienteDTO>

    fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDTO

    fun buscarClientePeloCpf(cpf: String): ClienteDTO?

    fun buscarClientePeloId(clienteId: UUID): Optional<ClienteDTO>
}
