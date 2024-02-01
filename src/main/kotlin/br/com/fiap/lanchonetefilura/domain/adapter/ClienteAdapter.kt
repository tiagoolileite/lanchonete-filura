package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDTO

interface ClienteAdapter {
    fun adaptarListaDeCliente(clientesDTO: List<ClienteDTO>): List<ClienteResponse>

    fun adaptarCliente(clienteDTO: ClienteDTO?): ClienteResponse
}
