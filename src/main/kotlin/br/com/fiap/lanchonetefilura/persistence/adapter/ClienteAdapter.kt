package br.com.fiap.lanchonetefilura.persistence.adapter

import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.persistence.dto.ClienteDTO

interface ClienteAdapter {
    fun adaptarClientesDtoParaClientes(clientesDTO : List<ClienteDTO>) : List<Cliente>

    fun adaptarClienteParaClienteDTO(cliente: Cliente) : ClienteDTO

    fun adaptarClienteDTOParaCliente(clienteDTO : ClienteDTO) : Cliente

}
