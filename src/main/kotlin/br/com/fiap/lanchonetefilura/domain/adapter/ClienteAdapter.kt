package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO

interface ClienteAdapter {
    fun adaptarClienteParaClienteDomainDto(cliente : Cliente) : ClienteDomainDTOImpl

    fun adaptarClientesDtoParaDomainDto(clientesDTO : List<ClienteDTO>) : List<ClienteDomainDTO>

    fun adaptarClienteDtoParaDomainDto(clienteDTO : ClienteDTO) : ClienteDomainDTOImpl

    fun adaptarClienteDomainDtoParaCliente(clienteDomainDTO : ClienteDomainDTO?) : Cliente
}
