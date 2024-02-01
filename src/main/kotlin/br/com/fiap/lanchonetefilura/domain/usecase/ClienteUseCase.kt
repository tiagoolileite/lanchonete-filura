package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import java.util.*

interface ClienteUseCase {
    fun listarClientes(): List<ClienteDomainDTO>

    fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDomainDTO

    fun buscarClientePeloCpf(cpf: String): ClienteDomainDTO

    fun buscarClientePeloId(clienteId: UUID): ClienteDomainDTO?
}
