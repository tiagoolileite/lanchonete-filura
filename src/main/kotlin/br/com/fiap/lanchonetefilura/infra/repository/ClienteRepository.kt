package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDTO
import java.util.*

interface ClienteRepository {

    fun listarClientes(): List<ClienteDTO>

    fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDTO

    fun buscarClientePeloCpf(cpf: String): ClienteDTO?

    fun buscarClientePeloId(clienteId: UUID): Optional<ClienteDTO>
}