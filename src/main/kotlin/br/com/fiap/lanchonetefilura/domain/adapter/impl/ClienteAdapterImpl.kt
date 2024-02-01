package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.domain.adapter.ClienteAdapter
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDTO
import org.springframework.stereotype.Component

@Component
class ClienteAdapterImpl : ClienteAdapter {
    override fun adaptarListaDeCliente(clientesDTO: List<ClienteDTO>): List<ClienteResponse> {
        val clientesResponse: ArrayList<ClienteResponse> = arrayListOf()

        clientesDTO.forEach {
            clientesResponse.add(
                ClienteResponse(
                    id = it.id,
                    cpf = it.cpf,
                    nome = it.nome,
                    email = it.email
                ))
        }

        return clientesResponse.toList()
    }

    override fun adaptarCliente(clienteDTO: ClienteDTO?): ClienteResponse {
        return ClienteResponse(
            id = clienteDTO?.id,
            cpf = clienteDTO?.cpf,
            nome = clienteDTO?.nome,
            email = clienteDTO?.email
        )
    }
}