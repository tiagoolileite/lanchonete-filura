package br.com.fiap.lanchonetefilura.infra.extensions

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import br.com.fiap.lanchonetefilura.core.domain.request.CategoriaRequestOld
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest
import br.com.fiap.lanchonetefilura.core.domain.request.ProdutoRequest

fun ClienteRequest.converterClienteRequestToClienteModel(): ClienteModel {
    return ClienteModel(
        cpf = this.cpf,
        nome = this.nome,
        email = this.email
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