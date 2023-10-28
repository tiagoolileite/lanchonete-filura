package br.com.fiap.lanchonetefilura.adapter.driver.api.extensions

import br.com.fiap.lanchonetefilura.adapter.driver.api.response.ClienteResponse
import br.com.fiap.lanchonetefilura.core.domain.dto.ClienteDTO


fun ClienteDTO?.converterClienteDtoToClienteResponse(): ClienteResponse {
    return ClienteResponse(
        cpf = this?.cpf,
        nome = this?.nome,
        email = this?.email
    )
}

fun List<ClienteDTO>?.converterListaClienteDtoToListaClienteResponse(): List<ClienteResponse> {

    val clientes: ArrayList<ClienteResponse> = arrayListOf()

    this?.forEach { cliente ->
        val clienteResponse = ClienteResponse(
            cpf = cliente.cpf,
            nome = cliente.nome,
            email = cliente.email
        )

        clientes.add(clienteResponse)
    }

    return clientes
}
