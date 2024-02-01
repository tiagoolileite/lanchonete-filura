package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl

interface ClienteController {

    fun listarClientes(): List<ClienteDTOImpl>

    fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDTOImpl

    fun buscarClientePeloCpf(cpf: String): ClienteDTOImpl

}
