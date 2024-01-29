package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.controller.ProdutoController
import br.com.fiap.lanchonetefilura.domain.usecase.CategoriaUseCase
import br.com.fiap.lanchonetefilura.domain.usecase.ProdutoUseCase
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.ArrayList

@Component
class ProdutoControllerImpl(
    val produtoUseCase: ProdutoUseCase,
    val categoriaUseCase: CategoriaUseCase
) : ProdutoController {

    override fun listarProdutos(): List<ProdutoResponse> {

        val produtosDTO: List<ProdutoDTO> = produtoUseCase.listarProdutos()

        val produtosResponse: ArrayList<ProdutoResponse> = arrayListOf()

        produtosDTO.forEach {
            produtosResponse.add(ProdutoResponse(
                id = it.id,
                nome = it.nome,
                descricao = it.descricao,
                preco = it.preco,
                categoria = CategoriaResponse(
                    id = it.categoria?.id,
                    descricao = it.categoria?.descricao
                )
            )
            )
        }

        return produtosResponse.toList()
    }

    override fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoResponse> {

        val produtosDTO: List<ProdutoDTO> = produtoUseCase.listarProdutosPorCategoria(categoriaId)

        val produtosResponse: ArrayList<ProdutoResponse> = arrayListOf()

        produtosDTO.forEach {
            produtosResponse.add(ProdutoResponse(
                id = it.id,
                nome = it.nome,
                descricao = it.descricao,
                preco = it.preco,
                categoria = CategoriaResponse(
                    id = it.categoria?.id,
                    descricao = it.categoria?.descricao
                )
            ))
        }

        return produtosResponse.toList()
    }

    override fun cadastrarProduto(
        categoriaId: UUID?,
        descricao: String?,
        nome: String?,
        preco: Double?
    ): ProdutoResponse {
        val categoriaDTO: CategoriaDTO? =
            categoriaUseCase.buscarCategoriaPeloId(categoriaId)

        val produtoDTO: ProdutoDTO? =
            categoriaDTO?.let { produtoUseCase.cadastrarProduto(it, descricao, nome, preco) }

        return  ProdutoResponse(
            id = produtoDTO?.id,
            nome = produtoDTO?.nome,
            descricao = produtoDTO?.descricao,
            preco = produtoDTO?.preco,
            categoria = CategoriaResponse(
                id = produtoDTO?.categoria?.id,
                descricao = produtoDTO?.categoria?.descricao
                )
        )
    }
}