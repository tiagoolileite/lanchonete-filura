package br.com.fiap.lanchonetefilura.api.mapper

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl

interface ClienteMapper {

    fun mapeiaClientesResponse(clientesDomainDTO: List<ClienteDTOImpl>): List<ClienteResponse>

    fun mapeiaClienteResponse(clienteDomainDTO : ClienteDTOImpl) : ClienteResponse

}
