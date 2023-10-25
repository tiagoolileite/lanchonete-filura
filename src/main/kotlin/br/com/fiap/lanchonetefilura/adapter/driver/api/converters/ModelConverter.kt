package br.com.fiap.lanchonetefilura.adapter.driver.api.converters

import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ClienteRequest
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel

fun converterClienteInputToClienteModel(clienteRequest: ClienteRequest): ClienteModel {
    return ClienteModel(
        cpf = clienteRequest.cpf,
        nome = clienteRequest.nome,
        email = clienteRequest.email
    )
}

fun converterFindAllClientesToArrayList(clientesIterable: Iterable<ClienteModel>): ArrayList<ClienteModel> {
    val clientes = arrayListOf<ClienteModel>()
    clientesIterable.forEach { clientes.add(it) }

    return clientes
}