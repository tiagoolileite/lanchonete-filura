package br.com.fiap.lanchonetefilura.adapter.driver.api.extensions

import br.com.fiap.lanchonetefilura.core.domain.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest

fun ClienteRequest.converterClienteRequestToClienteDTO(): ClienteModel {
    return ClienteModel(
        cpf = this.cpf,
        nome = this.nome,
        email = this.email
    )
}
