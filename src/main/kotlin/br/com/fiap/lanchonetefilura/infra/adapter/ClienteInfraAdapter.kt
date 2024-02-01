package br.com.fiap.lanchonetefilura.infra.adapter

import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl

interface ClienteInfraAdapter {
    fun adaptarClienteDomainDtoEmDtoImpl(cliente : ClienteDomainDTO?) : ClienteDTOImpl?
}