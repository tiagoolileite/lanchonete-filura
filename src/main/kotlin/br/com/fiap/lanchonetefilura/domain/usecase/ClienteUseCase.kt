package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import java.util.*

interface ClienteUseCase {
    fun listarClientes(): List<ClienteDTOImpl>

    fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDTOImpl

    fun buscarClientePeloCpf(cpf: String): ClienteDTOImpl

    fun buscarClientePeloId(clienteId: UUID): ClienteDTOImpl?
}
