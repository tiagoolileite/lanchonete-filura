package br.com.fiap.lanchonetefilura.api.mapper.impl

import br.com.fiap.lanchonetefilura.api.mapper.ClienteMapper
import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import org.springframework.stereotype.Component

@Component
class ClienteMapperImpl : ClienteMapper {
    override fun mapeiaClientesResponse(clientesDomainDTO: List<ClienteDTOImpl>): List<ClienteResponse> {
        return clientesDomainDTO.map { clienteDomainDTO ->
            mapeiaClienteResponse(clienteDomainDTO = clienteDomainDTO)
        }
    }

    override fun mapeiaClienteResponse(clienteDomainDTO : ClienteDTOImpl) : ClienteResponse {
        return ClienteResponse(
            id = clienteDomainDTO.id,
            cpf = clienteDomainDTO.cpf,
            nome = clienteDomainDTO.nome,
            email = clienteDomainDTO.email
        )
    }

}