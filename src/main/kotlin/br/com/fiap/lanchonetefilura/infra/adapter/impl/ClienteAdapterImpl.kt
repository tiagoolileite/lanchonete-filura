package br.com.fiap.lanchonetefilura.infra.adapter.impl

import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.infra.adapter.ClienteAdapter
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import org.springframework.stereotype.Component

@Component
class ClienteAdapterImpl : ClienteAdapter {
    override fun adaptarClientesDtoParaClientes(clientesDTO : List<ClienteDTO>) : List<Cliente> {
        return clientesDTO.map { clienteDTO ->
            adaptarClienteDTOParaCliente(clienteDTO = clienteDTO)
        }
    }

    override fun adaptarClienteParaClienteDTO(cliente : Cliente) : ClienteDTO {
        return cliente.id?.let {
            ClienteDTO(
                id = it,
                cpf = cliente.cpf,
                nome = cliente.nome,
                email = cliente.email
            )
        } ?: throw Exception("Falha ao adaptar lista de clientes")
    }

    override fun adaptarClienteDTOParaCliente(clienteDTO : ClienteDTO) : Cliente {
        return Cliente(
            id = clienteDTO.id,
            cpf = clienteDTO.cpf,
            nome = clienteDTO.nome,
            email = clienteDTO.email
        )
    }
}