package br.com.fiap.lanchonetefilura.core.extensions

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.PedidoModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel

fun ProdutoModel.editCategoriaModel(categoriaModel: CategoriaModel): ProdutoModel {
    return ProdutoModel(
        id = this.id,
        nome = this.nome,
        descricao = this.descricao,
        preco = this.preco,
        categoria = categoriaModel
    )
}

fun PedidoModel.updateEtapaPedidoModel(etapa: String): PedidoModel {
    return PedidoModel(
        id = this.id,
        senha = this.senha,
        etapa = etapa,
        cliente = this.cliente,
        produtos = this.produtos,
        pago = this.pago
    )
}