package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl

interface ClienteAdapter {
    fun adaptarClienteParaClienteDomainDto(cliente : Cliente) : ClienteDomainDTO

    fun adaptarClientesDtoParaDomainDto(clientesDTO : List<ClienteDTO>) : List<ClienteDTOImpl>

    fun adaptarClienteDtoParaDomainDto(clienteDTO : ClienteDTO) : ClienteDTOImpl
}
