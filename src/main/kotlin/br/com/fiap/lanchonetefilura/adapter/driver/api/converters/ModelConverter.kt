package br.com.fiap.lanchonetefilura.adapter.driver.api.converters

import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ClienteRequest
import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ProdutoRequest
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel

fun converterClienterequestToClienteModel(clienteRequest: ClienteRequest): ClienteModel {
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

fun converterProdutorequestToProdutoModel(produtoRequest: ProdutoRequest, categoria: CategoriaModel?): ProdutoModel {
    return ProdutoModel(
        nome = produtoRequest.nome,
        descricao = produtoRequest.descricao,
        preco = produtoRequest.preco,
        categoria = categoria
    )
}

fun converterFindAllProdutosToArrayList(produtosIterable: Iterable<ProdutoModel>): ArrayList<ProdutoModel> {
    val produtos = arrayListOf<ProdutoModel>()
    produtosIterable.forEach { produtos.add(it) }

    return produtos
}