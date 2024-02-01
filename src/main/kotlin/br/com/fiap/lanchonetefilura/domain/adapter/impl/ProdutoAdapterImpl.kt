package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.domain.adapter.ProdutoAdater
import br.com.fiap.lanchonetefilura.domain.dto.impl.ProdutoDTO
import org.springframework.stereotype.Component

@Component
class ProdutoAdapterImpl(val categoriaAdapter: CategoriaAdapter) : ProdutoAdater {
    override fun adaptarListaDeProdutos(produtos: List<ProdutoDTO>): List<ProdutoResponse> {

        val produtosResponse: ArrayList<ProdutoResponse> = arrayListOf()

        produtos.forEach { produto ->

            val categoriaAdaptada: CategoriaResponse =
                categoriaAdapter.adaptarCategoria(
                    produto.categoria
                )

            produtosResponse.add(
                ProdutoResponse(
                    id = produto.id,
                    nome = produto.nome,
                    descricao = produto.descricao,
                    preco = produto.preco,
                    categoria = categoriaAdaptada
                )
            )
        }

        return produtosResponse.toList()
    }

    override fun adaptarProduto(
        produtoDTO: ProdutoDTO
    ): ProdutoResponse {
        val categoriaAdaptada: CategoriaResponse =
            categoriaAdapter.adaptarCategoria(produtoDTO.categoria)

        return  ProdutoResponse(
            id = produtoDTO.id,
            nome = produtoDTO.nome,
            descricao = produtoDTO.descricao,
            preco = produtoDTO.preco,
            categoria = categoriaAdaptada
        )
    }
}