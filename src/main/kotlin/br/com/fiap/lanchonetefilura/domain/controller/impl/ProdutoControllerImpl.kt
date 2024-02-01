package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.adapter.ProdutoAdater
import br.com.fiap.lanchonetefilura.domain.controller.ProdutoController
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.domain.dto.impl.ProdutoDTO
import br.com.fiap.lanchonetefilura.domain.usecase.CategoriaUseCase
import br.com.fiap.lanchonetefilura.domain.usecase.ProdutoUseCase
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoControllerImpl(
    val produtoUseCase: ProdutoUseCase,
    val categoriaUseCase: CategoriaUseCase,
    val produtoAdapter: ProdutoAdater,
) : ProdutoController {

    override fun listarProdutos(): List<ProdutoResponse> {

        val produtosDTO: List<ProdutoDTO> = produtoUseCase.listarProdutos()

        return produtoAdapter.adaptarListaDeProdutos(produtosDTO)
    }

    override fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoResponse> {

        val produtosDTO: List<ProdutoDTO> = produtoUseCase.listarProdutosPorCategoria(categoriaId)

        return produtoAdapter.adaptarListaDeProdutos(produtosDTO)
    }

    override fun cadastrarProduto(
        categoriaId: UUID,
        descricao: String?,
        nome: String?,
        preco: Double?
    ): ProdutoResponse {

        LoggerHelper.logger.info("[FILURA]: categoriaId teste: ${categoriaId}")

        val categoriaDTO: CategoriaDTOImpl =
            categoriaUseCase.buscarCategoriaPeloId(categoriaId)

        LoggerHelper.logger.info("[FILURA]: categoriaId teste2: ${categoriaDTO.id}")

        val produtoDTO: ProdutoDTO =
            categoriaDTO.let { produtoUseCase.cadastrarProduto(it, descricao, nome, preco) }

        LoggerHelper.logger.info("[FILURA]: categoriaId teste3: ${produtoDTO.categoria?.id}")

        return produtoAdapter.adaptarProduto(produtoDTO = produtoDTO)
    }

    override fun atualizaProduto(
        id: UUID,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): ProdutoResponse? {
        val produtoDTO: ProdutoDTO? =
            produtoUseCase.buscarProdutoPeloId(id)

        if (produtoDTO?.id == null) {
            throw Exception("Produto não localizado para atualização")
        }

        val produtoAtualizadoDTO: ProdutoDTO =
            produtoUseCase.atualizarProduto(produtoDTO, nome, categoriaId, preco, descricao)

        return produtoAdapter.adaptarProduto(produtoAtualizadoDTO)
    }

    override fun deletarProdutoPeloId(id: UUID) {
        produtoUseCase.deletarProdutoPeloId(id)
    }
}