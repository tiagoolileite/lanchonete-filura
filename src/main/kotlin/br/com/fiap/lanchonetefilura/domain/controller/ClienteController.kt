package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse

interface ClienteController {

    fun listarClientes(): List<ClienteResponse>

    fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteResponse

    fun buscarClientePeloCpf(cpf: String): ClienteResponse

}
