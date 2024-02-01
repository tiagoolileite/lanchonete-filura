package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.domain.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.domain.adapter.ProdutoAdapter
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.dto.impl.ProdutoDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.infra.adapter.CategoriaInfraAdapter
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoAdapterImpl (
    val categoriaInfraAdapter: CategoriaInfraAdapter,
    val categoriaAdapter : CategoriaAdapter
) : ProdutoAdapter {
    override fun adaptarProdutoParaProdutoDTO(
        produto: Produto,
        categoriaDomainDTO: CategoriaDomainDTOImpl?
    ): ProdutoDomainDTOImpl {
        return ProdutoDomainDTOImpl(
            nome = produto.nome,
            descricao = produto.descricao,
            preco = produto.preco,
            categoria = categoriaDomainDTO
        )
    }

    override fun adaptarProdutoParaProdutoDTOExistente(
        produto: Produto,
        id: UUID,
        categoriaDomainDTO: CategoriaDomainDTOImpl?
    ): ProdutoDomainDTO {
        return categoriaDomainDTO?.let {
            ProdutoDomainDTOImpl(
                id = id,
                nome = produto.nome,
                descricao = produto.descricao,
                preco = produto.preco,
                categoria = it
            )
        } ?: also {
            LoggerHelper.logger.error("${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: " +
                    "Falha ao converter Produto para ProdutoDTO Existente")
        }.run { throw Exception("Falha ao converter Produto para ProdutoDTO Existente") }
    }

    override fun adaptarProdutosDtoParaDomainDto(produtosDTO: List<ProdutoDTO>): List<ProdutoDomainDTO> {
        return produtosDTO.map { produtoDTO ->
            object : ProdutoDomainDTO {
                override var id: UUID?
                    get() = produtoDTO.id
                    set(value) {
                        produtoDTO.id = value
                    }

                override var nome: String?
                    get() = produtoDTO.nome
                    set(value) {
                        produtoDTO.nome = value
                    }

                override var descricao: String?
                    get() = produtoDTO.descricao
                    set(value) {
                        produtoDTO.descricao = value
                    }

                override var preco: Double?
                    get() = produtoDTO.preco
                    set(value) {
                        produtoDTO.preco = value
                    }

                override var categoria: CategoriaDomainDTOImpl?
                    get() =
                        produtoDTO.categoria?.id?.let {
                            CategoriaDomainDTOImpl(
                                it,
                                produtoDTO.categoria?.descricao
                            )
                        }
                    set(value) {produtoDTO.categoria = categoriaInfraAdapter.initCategoriaDTO(
                        value?.id,
                        value?.descricao
                    ) }
                override val pedidos: List<PedidoDomainDTOImpl>?
                    get() = null
            }
        }
    }

    override fun adaptarProdutosDtoParaDomainDtoImpl(produtosDTO: List<ProdutoDTO>): List<ProdutoDomainDTOImpl> {
        return produtosDTO.map { produtoDTO ->
            ProdutoDomainDTOImpl(
                id = produtoDTO.id,
                nome = produtoDTO.descricao,
                descricao = produtoDTO.descricao,
                preco = produtoDTO.preco,
                categoria = produtoDTO.categoria?.let { categoriaAdapter.adaptarCategoriaDtoParaDomainDto(it) }
            )
        }
    }

    override fun adaptarProdutoDtoParaDomainDto(produtoDTO: ProdutoDTO): ProdutoDomainDTO {
        return ProdutoDomainDTOImpl (
            id = produtoDTO.id,
            nome = produtoDTO.nome,
            descricao = produtoDTO.descricao,
            preco = produtoDTO.preco,
            categoria = adaptarCategoriaDtoEmCategoriaDomainDto(produtoDTO.categoria)
        )
    }

    override fun adaptarProdutoDtoParaOptionalDomainDto(produtoOptionalDTO: Optional<ProdutoDTO>): Optional<ProdutoDomainDTO> {
        return produtoOptionalDTO.map { produtoDTO ->
            adaptarProdutoDtoParaDomainDto(produtoDTO)
        }
    }

    override fun adaptarProdutosMutableDtoParaMutableDomainDto(produtosDTO: MutableList<ProdutoDTO>): MutableList<ProdutoDomainDTO> {
        return adaptarProdutosDtoParaDomainDto(produtosDTO).toMutableList()
    }

    override fun adaptarProdutosDomainDtoParaProdutos(produtosDomainDTO : List<ProdutoDomainDTO>) : List<Produto> {
        return produtosDomainDTO.map { produtoDomainDTO ->
            Produto(
                nome = produtoDomainDTO.nome,
                descricao = produtoDomainDTO.descricao,
                preco = produtoDomainDTO.preco,
                categoria = categoriaAdapter.adaptarCategoriaDomainDtoParaCategoria(produtoDomainDTO.categoria)
            )
        }
    }

    override fun adaptarProdutosParaProdutosDomainDto(produtos : List<Produto>) : List<ProdutoDomainDTOImpl> {
        return produtos.map {  produto ->
            adaptarProdutoParaProdutoDTO(produto,
                produto.categoria?.let { categoriaAdapter.adaptarCategoriaParaCategoriaDto(it) })
        }
    }

    private fun adaptarCategoriaDtoEmCategoriaDomainDto(categoria: CategoriaDTO?): CategoriaDomainDTOImpl {
        return categoria?.id?.let {
            CategoriaDomainDTOImpl (
                id = it,
                descricao = categoria.descricao
            )
        } ?: also {
            LoggerHelper.logger.error("${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: " +
                    "Falha ao converter CategoriaDTO em CategoriaDomainDTO")
        }.run { throw Exception("Falha ao converter CategoriaDTO em CategoriaDomainDTO") }
    }

}