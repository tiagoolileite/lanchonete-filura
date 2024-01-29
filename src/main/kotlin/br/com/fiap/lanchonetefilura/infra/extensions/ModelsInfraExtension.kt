package br.com.fiap.lanchonetefilura.infra.extensions

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import br.com.fiap.lanchonetefilura.core.domain.request.ClienteRequest
import br.com.fiap.lanchonetefilura.core.domain.request.ProdutoRequestOld

fun ClienteRequest.converterClienteRequestToClienteModel(): ClienteModel {
    return ClienteModel(
        cpf = this.cpf,
        nome = this.nome,
        email = this.email
    )
}

fun ProdutoRequestOld.converterProdutoRequestToProdutoModel(categoriaModel: CategoriaModel): ProdutoModel {
    return ProdutoModel(
        nome = this.nome,
        descricao = this.descricao,
        preco = this.preco,
        categoria = categoriaModel
    )
}