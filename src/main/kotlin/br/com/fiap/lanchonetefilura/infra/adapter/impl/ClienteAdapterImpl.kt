package br.com.fiap.lanchonetefilura.infra.adapter.impl

import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.infra.adapter.ClienteAdapter
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import org.springframework.stereotype.Component

@Component
class ClienteAdapterImpl : ClienteAdapter {
    override fun adaptarClientesDtoParaClientes(findAll : List<ClienteDTO>) : List<Cliente> {
        TODO("Not yet implemented")
    }

    override fun adaptarClienteParaClienteDTO(cliente : Cliente) : ClienteDTO {
        TODO("Not yet implemented")
    }

    override fun adaptarClienteDTOParaCliente(clienteDTO : ClienteDTO) : Cliente {
        TODO("Not yet implemented")
    }
}