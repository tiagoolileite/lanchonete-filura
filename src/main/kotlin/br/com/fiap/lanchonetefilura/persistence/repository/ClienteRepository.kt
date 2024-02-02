package br.com.fiap.lanchonetefilura.persistence.repository

import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import java.util.*

interface ClienteRepository {

    fun listarClientes(): List<Cliente>

    fun cadastrarCliente(cliente : Cliente): Cliente

    fun buscarClientePeloCpf(cpf: String): Cliente?

    fun buscarClientePeloId(clienteId: UUID): Optional<Cliente>
}