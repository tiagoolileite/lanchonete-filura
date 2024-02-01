package br.com.fiap.lanchonetefilura.api.mapper

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO

interface ClienteMapper {

    fun mapeiaClientesResponse(clientesDomainDTO: List<ClienteDomainDTO>): List<ClienteResponse>

    fun mapeiaClienteResponse(clienteDomainDTO : ClienteDomainDTO) : ClienteResponse

}
