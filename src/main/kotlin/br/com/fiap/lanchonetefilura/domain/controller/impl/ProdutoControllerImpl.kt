package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.domain.controller.ProdutoController
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDTO
import br.com.fiap.lanchonetefilura.domain.usecase.ProdutoUseCase
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoControllerImpl(
    val useCase: ProdutoUseCase
) : ProdutoController {

    override fun listarProdutos(): List<ProdutoDTO> {
        return useCase.listarProdutos()
    }

    override fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDTO> {
        return useCase.listarProdutosPorCategoria(categoriaId = categoriaId)
    }

    override fun cadastrarProduto(
        categoriaId: UUID,
        descricao: String?,
        nome: String?,
        preco: Double?
    ): ProdutoDTO {

        return useCase.cadastrarProduto(
            categoriaId = categoriaId,
            descricao = descricao,
            nome = nome,
            preco = preco
        )
    }

    override fun atualizaProduto(
        id: UUID,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): ProdutoDTO {

        return useCase.atualizarProduto(
            produtoId = id,
            nome = nome,
            categoriaId = categoriaId,
            preco = preco,
            descricao = descricao
        )
    }

    override fun deletarProdutoPeloId(produtoId: UUID) {
        useCase.deletarProdutoPeloId(produtoId)
    }
}