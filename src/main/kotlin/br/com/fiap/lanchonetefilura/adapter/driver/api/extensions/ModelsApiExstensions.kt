package br.com.fiap.lanchonetefilura.adapter.driver.api.extensions

import br.com.fiap.lanchonetefilura.adapter.driver.api.response.ClienteResponse
import br.com.fiap.lanchonetefilura.adapter.driver.api.response.PedidoResponse
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.core.domain.model.PedidoModel
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

/*fun List<ProdutoModel?>?.converterListaProdutosModelToListaProdutosResponse(): List<ProdutoResponse> {

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
}*/

/*
fun ProdutoModel?.converterProdutoModelToProdutoResponse(): ProdutoResponse {
    return ProdutoResponse(
        id = this?.id,
        nome = this?.nome,
        descricao = this?.descricao,
        preco = this?.preco,
        categoria = this?.categoria
    )
}
*/

fun List<PedidoModel>?.converterListaPedidosModelToListaPedidosResponse(): List<PedidoResponse> {

    val pedidos: ArrayList<PedidoResponse> = arrayListOf()

    this?.forEach { pedido ->
        val pedidoResponse = PedidoResponse(
            id = pedido.id,
            senha = pedido.senha,
            etapa = pedido.etapa,
            cliente = pedido.cliente,
            produtos = pedido.produtos,
            pago = pedido.pago
        )

        pedidos.add(pedidoResponse)
    }

    return pedidos
}

fun PedidoModel.converterPedidoModelToPedidoResponse(): PedidoResponse {
    return PedidoResponse(
        id = this.id,
        senha = this.senha,
        etapa = this.etapa,
        cliente = this.cliente,
        produtos = this.produtos,
        pago = this.pago
    )
}