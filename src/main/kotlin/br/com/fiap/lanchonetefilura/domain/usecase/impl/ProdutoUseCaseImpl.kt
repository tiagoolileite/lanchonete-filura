package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.adapter.ProdutoAdapter
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.domain.exceptions.DomainExceptionHelper
import br.com.fiap.lanchonetefilura.domain.gateway.ProdutoGateway
import br.com.fiap.lanchonetefilura.domain.usecase.CategoriaUseCase
import br.com.fiap.lanchonetefilura.domain.usecase.ProdutoUseCase
import br.com.fiap.lanchonetefilura.infra.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoUseCaseImpl(
    val gateway: ProdutoGateway,
    val adapter: ProdutoAdapter,
    val categoriaUseCase: CategoriaUseCase
) : ProdutoUseCase {
    override fun listarProdutos(): List<ProdutoDomainDTO> {
        return gateway.listarProdutos()
    }

    override fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDomainDTO> {
        return gateway.listarProdutosPorCategoria(categoriaId)
    }

    override fun cadastrarProduto(
        categoriaId: UUID,
        descricao: String?,
        nome: String?,
        preco: Double?
    ): ProdutoDomainDTO {

        val categoriaDTO: CategoriaDTOImpl? = categoriaUseCase.buscarCategoriaPeloId(categoriaId)

        val categoria = Categoria(categoriaDTO?.descricao)

        val produto = Produto(
            nome = nome,
            descricao = descricao,
            preco = preco,
            categoria = categoria,
        )

        val produtoDTO: ProdutoDomainDTO = adapter.adaptarProdutoParaProdutoDTO(
            produto = produto,
            categoriaDTO = categoriaDTO
        )

        return gateway.cadastrarProduto(produtoDTO)
    }

    override fun buscarProdutoPeloId(id: UUID): ProdutoDomainDTO {

        val produtoDTO: Optional<ProdutoDomainDTO> = gateway.buscarProdutoPeloId(id)

        if (produtoDTO.isEmpty) {
            LoggerHelper.logger.error(
                "${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: " +
                        DomainExceptionHelper.ERROR_PRODUTO_NAO_LOCALIZADO
            )
            throw Exception(DomainExceptionHelper.ERROR_PRODUTO_NAO_LOCALIZADO)
        }

        return produtoDTO.get()
    }

    override fun atualizarProduto(
        produtoId: UUID,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): ProdutoDomainDTO {

        val categoriaDTO: CategoriaDTOImpl? = categoriaId?.let { categoriaUseCase.buscarCategoriaPeloId(it) }

        val categoria = Categoria(categoriaDTO?.descricao)

        val produtoDTO: ProdutoDomainDTO =
            this.buscarProdutoPeloId(id = produtoId)

        val produto = Produto(
            nome = nome,
            descricao = descricao,
            preco = preco,
            categoria = categoria,
        )

        val produtoAtualizadoDTO: ProdutoDomainDTO? = produtoDTO.id?.let {
            adapter.adaptarProdutoParaProdutoDTOExistente(
                produto = produto,
                id = it,
                categoriaDTO = categoriaDTO
            )
        }

        return produtoAtualizadoDTO?.let { gateway.atualizarProduto(it) } ?: also {
            "${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: " +
                    DomainExceptionHelper.ERROR_PRODUTO_NAO_FOI_POSSIVEL_LOCALIZAR
        }.run {
            throw Exception(DomainExceptionHelper.ERROR_PRODUTO_NAO_FOI_POSSIVEL_LOCALIZAR)
        }
    }

    override fun deletarProdutoPeloId(produtoId: UUID) {
        gateway.deletarProdutoPeloId(produtoId)
    }

    override fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): List<ProdutoDomainDTO> {

        val produtos: MutableList<ProdutoDomainDTO> = gateway.listarProdutosPorListaDeIds(produtosId)

        return produtos.toList()
    }
}