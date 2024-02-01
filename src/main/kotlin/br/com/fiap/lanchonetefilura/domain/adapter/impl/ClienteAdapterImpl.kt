package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.domain.adapter.ClienteAdapter
import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import org.springframework.stereotype.Component

@Component
class ClienteAdapterImpl : ClienteAdapter {
    override fun adaptarClienteParaClienteDomainDto(cliente : Cliente) : ClienteDomainDTO {
        return ClienteDomainDTOImpl(
            cpf = cliente.cpf,
            nome = cliente.nome,
            email = cliente.email
        )
    }

    override fun adaptarClientesDtoParaDomainDto(clientesDTO : List<ClienteDTO>) : List<ClienteDTOImpl> {
        return clientesDTO.map { clienteDTO ->
            adaptarClienteDtoParaDomainDto(clienteDTO)
        }
    }

    override fun adaptarClienteDtoParaDomainDto(clienteDTO : ClienteDTO) : ClienteDTOImpl {
        return ClienteDTOImpl(
            id = clienteDTO.id,
            cpf = clienteDTO.cpf,
            nome = clienteDTO.nome,
            email = clienteDTO.email
        )
    }

}