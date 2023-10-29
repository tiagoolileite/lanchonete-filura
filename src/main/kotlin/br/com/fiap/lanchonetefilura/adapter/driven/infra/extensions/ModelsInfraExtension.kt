package br.com.fiap.lanchonetefilura.adapter.driven.infra.extensions

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.request.CategoriaRequest
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest

fun ClienteRequest.converterClienteRequestToClienteDTO(): ClienteModel {
    return ClienteModel(
        cpf = this.cpf,
        nome = this.nome,
        email = this.email
    )
}

fun CategoriaRequest.converterCategoriaRequestToCategoriaDTO(): CategoriaModel {
    return CategoriaModel (
        descricao = this.descricao
    )
}