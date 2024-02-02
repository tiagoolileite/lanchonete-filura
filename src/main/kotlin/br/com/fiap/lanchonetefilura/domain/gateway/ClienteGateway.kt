package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import java.util.*

interface ClienteGateway {
    fun listarClientes(): List<Cliente>

    fun cadastrarCliente(cliente : Cliente): Cliente

    fun buscarClientePeloCpf(cpf: String): Cliente?

    fun buscarClientePeloId(clienteId: UUID): Optional<Cliente>
}
