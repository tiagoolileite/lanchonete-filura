package br.com.fiap.lanchonetefilura.infra.adapter.impl

import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.infra.adapter.ClienteInfraAdapter
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import org.springframework.stereotype.Component

@Component
class ClienteInfraAdapterImpl: ClienteInfraAdapter {
    override fun adaptarClienteDomainDtoEmDtoImpl(cliente : ClienteDomainDTO?) : ClienteDTOImpl? {
        return cliente?.id?.let {
            ClienteDTOImpl(
                id = it,
                cpf = cliente.cpf,
                nome = cliente.nome,
                email = cliente.email
                )
        }
    }


}
