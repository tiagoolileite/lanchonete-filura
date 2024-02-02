package br.com.fiap.lanchonetefilura.api.mapper.impl

import br.com.fiap.lanchonetefilura.api.mapper.CategoriaMapper
import br.com.fiap.lanchonetefilura.api.mapper.ProdutoMapper
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.entity.Produto
import org.springframework.stereotype.Component

@Component
class ProdutoMapperImpl(val categoriaMapper: CategoriaMapper) : ProdutoMapper {
    override fun mapeiaProdutosResponse(produtos : List<Produto>): List<ProdutoResponse> {

        val produtosResponse: ArrayList<ProdutoResponse> = arrayListOf()

        produtos.forEach { produto ->
            produtosResponse.add(
                mapeiaProdutoResponse(produto = produto)
            )
        }

        return produtosResponse
    }

    override fun mapeiaProdutoResponse(produto: Produto): ProdutoResponse {
        val categoriaResponse = produto.categoria.let {
            categoriaMapper.mapeiaCategoriaResponse(categoria = it)
        }

        return ProdutoResponse(
            id = produto.id,
            nome = produto.nome,
            descricao = produto.descricao,
            preco = produto.preco,
            categoria = categoriaResponse
        )
    }
}