package br.com.fiap.lanchonetefilura.persistence.adapter.impl

import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.persistence.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.persistence.adapter.ProdutoAdapter
import br.com.fiap.lanchonetefilura.persistence.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.persistence.dto.ProdutoDTO
import org.springframework.stereotype.Component

@Component
class ProdutoAdapterImpl (
    private val categoriaAdapter : CategoriaAdapter
) : ProdutoAdapter {
    override fun adaptarProdutosDTOParaProdutos(produtosDTO : List<ProdutoDTO>) : List<Produto> {
        return produtosDTO.map { produtoDTO ->
            adaptarProdutoDTOParaProduto(produtoDTO)
        }
    }

    override fun adaptarProdutoParaProdutoDTO(produto : Produto) : ProdutoDTO {
        return ProdutoDTO(
            id = produto.id,
            nome = produto.nome,
            descricao = produto.descricao,
            preco = produto.preco,
            categoria = categoriaAdapter.adaptarCategoriaParaCategoriaDto(produto.categoria),
            pedidos = null
        )
    }

    override fun adaptarProdutoDTOParaProduto(produtoDTO : ProdutoDTO) : Produto {
        return produtoDTO.id?.let { id ->
            produtoDTO.nome?.let { nome ->
                produtoDTO.descricao?.let { descricao ->
                    produtoDTO.preco?.let { preco ->
                        produtoDTO.categoria?.let { categoriaDTO: CategoriaDTO ->
                            Produto(
                                id = id,
                                nome = nome,
                                descricao = descricao,
                                preco = preco,
                                categoria =
                                categoriaAdapter.adaptarCategoriaDtoParaCategoria(categoriaDTO = categoriaDTO)
                            )
                        }

                    } ?: throw Exception("Falha ao converter produtos")
                } ?: throw Exception("Falha ao converter produtos")
            } ?: throw Exception("Falha ao converter produtos")
        } ?: throw Exception("Falha ao converter produtos")
    }

    override fun adaptarProdutosParaProdutosDTO(produtos : List<Produto>) : List<ProdutoDTO> {
        return produtos.map { produto: Produto ->
            adaptarProdutoParaProdutoDTO(produto)
        }
    }
}