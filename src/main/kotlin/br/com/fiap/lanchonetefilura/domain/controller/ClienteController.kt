package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO

interface ClienteController {

    fun listarClientes(): List<ClienteDomainDTO>

    fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDomainDTO

    fun buscarClientePeloCpf(cpf: String): ClienteDomainDTO

}
