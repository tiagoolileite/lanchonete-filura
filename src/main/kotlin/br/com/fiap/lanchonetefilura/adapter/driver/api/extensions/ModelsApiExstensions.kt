package br.com.fiap.lanchonetefilura.adapter.driver.api.extensions

import br.com.fiap.lanchonetefilura.adapter.driver.api.response.CategoriaResponse
import br.com.fiap.lanchonetefilura.adapter.driver.api.response.ClienteResponse
import br.com.fiap.lanchonetefilura.adapter.driver.api.response.ProdutoResponse
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel

fun ClienteModel?.converterClienteModelToClienteResponse(): ClienteResponse {
    return ClienteResponse(
        id = this?.id,
        cpf = this?.cpf,
        nome = this?.nome,
        email = this?.email
    )
}

fun List<ClienteModel?>?.converterListaClienteModelToListaClienteResponse(): List<ClienteResponse> {

    val clientes: ArrayList<ClienteResponse> = arrayListOf()

    this?.forEach { cliente ->
        val clienteResponse = ClienteResponse(
            id = cliente?.id,
            cpf = cliente?.cpf,
            nome = cliente?.nome,
            email = cliente?.email
        )

        clientes.add(clienteResponse)
    }

    return clientes
}

fun List<CategoriaModel?>?.converterListaCategoriasModelToListaCategoriasResponse(): List<CategoriaResponse> {

    val categorias: ArrayList<CategoriaResponse> = arrayListOf()

    this?.forEach { categoria ->
        categoria?.id?.let {
            categorias.add(
                CategoriaResponse(
                id = it,
                descricao = categoria.descricao,

            )
            )
        }
    }

    return categorias
}

fun CategoriaModel?.converterCategoriaModelToCategoriaResponse(): CategoriaResponse {
    return CategoriaResponse(
        id = this?.id,
        descricao = this?.descricao
    )
}

fun List<ProdutoModel?>?.converterListaProdutosModelToListaProdutosResponse(): List<ProdutoResponse> {

    val produtos: ArrayList<ProdutoResponse> = arrayListOf()

    this?.forEach { produto ->
        val produtoResponse = ProdutoResponse(
            id = produto?.id,
            nome = produto?.nome,
            descricao = produto?.descricao,
            preco = produto?.preco,
            categoria = produto?.categoria
        )

        produtos.add(produtoResponse)
    }

    return produtos
}

fun ProdutoModel?.converterProdutoModelToProdutoResponse(): ProdutoResponse {
    return ProdutoResponse(
        id = this?.id,
        nome = this?.nome,
        descricao = this?.descricao,
        preco = this?.preco,
        categoria = this?.categoria
    )
}