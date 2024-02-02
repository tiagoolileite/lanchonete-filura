package br.com.fiap.lanchonetefilura.api.mapper.impl

import br.com.fiap.lanchonetefilura.api.mapper.ClienteMapper
import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import org.springframework.stereotype.Component

@Component
class ClienteMapperImpl : ClienteMapper {
    override fun mapeiaClientesResponse(clientes: List<Cliente>): List<ClienteResponse> {
        return clientes.map { cliente ->
            mapeiaClienteResponse(cliente = cliente)
        }
    }

    override fun mapeiaClienteResponse(cliente : Cliente?) : ClienteResponse {
        return ClienteResponse(
            id = cliente?.id,
            cpf = cliente?.cpf,
            nome = cliente?.nome,
            email = cliente?.email
        )
    }

}