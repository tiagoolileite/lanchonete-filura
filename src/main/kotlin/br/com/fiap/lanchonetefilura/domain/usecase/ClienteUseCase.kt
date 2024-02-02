package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import java.util.*

interface ClienteUseCase {
    fun listarClientes(): List<Cliente>

    fun cadastrarCliente(cpf: String?, nome: String?, email: String?): Cliente?

    fun buscarClientePeloCpf(cpf: String): Cliente?

    fun buscarClientePeloId(clienteId: UUID): Cliente?
}
