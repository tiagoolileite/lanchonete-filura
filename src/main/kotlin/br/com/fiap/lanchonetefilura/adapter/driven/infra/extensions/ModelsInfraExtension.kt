package br.com.fiap.lanchonetefilura.adapter.driven.infra.extensions

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import br.com.fiap.lanchonetefilura.core.domain.request.CategoriaRequest
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest
import br.com.fiap.lanchonetefilura.core.domain.request.ProdutoRequest

fun ClienteRequest.converterClienteRequestToClienteModel(): ClienteModel {
    return ClienteModel(
        cpf = this.cpf,
        nome = this.nome,
        email = this.email
    )
}

fun CategoriaRequest.converterCategoriaRequestToCategoriaModel(): CategoriaModel {
    return CategoriaModel (
        descricao = this.descricao
    )
}

fun ProdutoRequest.converterProdutoRequestToProdutoModel(categoriaModel: CategoriaModel): ProdutoModel {
    return ProdutoModel(
        nome = this.nome,
        descricao = this.descricao,
        preco = this.preco,
        categoria = categoriaModel
    )
}