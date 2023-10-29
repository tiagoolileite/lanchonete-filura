package br.com.fiap.lanchonetefilura.adapter.driver.api.extensions

import br.com.fiap.lanchonetefilura.adapter.driver.api.response.CategoriaResponse
import br.com.fiap.lanchonetefilura.adapter.driver.api.response.ClienteResponse
import br.com.fiap.lanchonetefilura.core.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.core.domain.dto.ClienteDTO

fun ClienteDTO?.converterClienteDtoToClienteResponse(): ClienteResponse {
    return ClienteResponse(
        id = this?.id,
        cpf = this?.cpf,
        nome = this?.nome,
        email = this?.email
    )
}

fun List<ClienteDTO?>?.converterListaClienteDtoToListaClienteResponse(): List<ClienteResponse> {

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

fun List<CategoriaDTO?>?.converterListaCategoriasDtoToListaCategoriasResponse(): List<CategoriaResponse> {

    val categorias: ArrayList<CategoriaResponse> = arrayListOf()

    this?.forEach { categoria ->
        val categoriaResponse = CategoriaResponse(
            id = categoria?.id,
            descricao = categoria?.descricao,

        )

        categorias.add(categoriaResponse)
    }

    return categorias
}

fun CategoriaDTO?.converterCategoriaDtoToCategoriaResponse(): CategoriaResponse {
    return CategoriaResponse(
        id = this?.id,
        descricao = this?.descricao
    )
}
