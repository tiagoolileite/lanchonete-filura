package br.com.fiap.lanchonetefilura.api.mapper.impl

import br.com.fiap.lanchonetefilura.api.mapper.CategoriaMapper
import br.com.fiap.lanchonetefilura.api.mapper.ProdutoMapper
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDTO
import org.springframework.stereotype.Component

@Component
class ProdutoMapperImpl(val categoriaMapper: CategoriaMapper) : ProdutoMapper {
    override fun mapeiaProdutosResponse(produtosDTO: List<ProdutoDTO>): List<ProdutoResponse> {

        val produtosResponse: ArrayList<ProdutoResponse> = arrayListOf()

        produtosDTO.forEach { produtoDTO ->
            produtosResponse.add(
                mapeiaProdutoResponse(produtoDTO)
            )
        }

        return produtosResponse
    }

    override fun mapeiaProdutoResponse(produtoDTO: ProdutoDTO): ProdutoResponse {
        val categoriaResponse = produtoDTO.categoria?.let { categoriaMapper.mapeiaCategoriaResponse(it) }

        return ProdutoResponse(
            id = produtoDTO.id,
            nome = produtoDTO.nome,
            descricao = produtoDTO.descricao,
            preco = produtoDTO.preco,
            categoria = categoriaResponse
        )
    }
}