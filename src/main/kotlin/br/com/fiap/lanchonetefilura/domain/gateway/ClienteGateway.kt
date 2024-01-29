package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO

interface ClienteGateway {
    fun listarClientes(): List<ClienteDTO>

    fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDTO

    fun buscarClientePeloCpf(cpf: String): ClienteDTO?

}
