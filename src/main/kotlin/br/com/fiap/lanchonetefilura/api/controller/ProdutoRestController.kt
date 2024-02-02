package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.mapper.ProdutoMapper
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoRequest
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.domain.exceptions.produto.ProdutoInvalidaException
import br.com.fiap.lanchonetefilura.domain.usecase.ProdutoUseCase
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/produto")
class ProdutoRestController(
    val useCase: ProdutoUseCase,
    val mapper: ProdutoMapper
) {

    @GetMapping("/produtos")
    @ResponseStatus(HttpStatus.OK)
    fun listarProdutos(): ResponseEntity<List<ProdutoResponse>> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Solicitando listagem de produtos")

        val produto: List<Produto>  =
            useCase.listarProdutos()

        val produtosResponse: List<ProdutoResponse> =
            mapper.mapeiaProdutosResponse(produtos = produto)

        return ResponseEntity.ok(produtosResponse).let { response ->
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Busca por produtos realizada com sucesso")
            response
        }
    }

    @GetMapping("/produtos/categoria")
    @ResponseStatus(HttpStatus.OK)
    fun listarProdutosPorCategoria(
        @RequestParam("categoria_id") categoriaId: UUID
    ): ResponseEntity<List<ProdutoResponse>> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Solicitando listagem de produtos por categoria")

        val produtos: List<Produto>  =
            useCase.listarProdutosPorCategoria(categoriaId = categoriaId)

        val produtosResponse: List<ProdutoResponse> =
            mapper.mapeiaProdutosResponse(produtos = produtos)

        return ResponseEntity.ok(produtosResponse).let { response ->
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Busca por produtos realizada com sucesso!")
            response
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarProduto(
        @RequestBody @Valid produtoRequest: ProdutoRequest
    ): ResponseEntity<ProdutoResponse> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Solicitando cadastro do produto ${produtoRequest.nome}")

        val produto: Produto =
            produtoRequest.categoriaId?.let { categoria ->
                produtoRequest.nome?.let { nome ->
                    produtoRequest.descricao?.let { descricao ->
                        produtoRequest.preco?.let { preco ->
                            useCase.cadastrarProduto(
                                categoriaId = categoria,
                                descricao = descricao,
                                nome = nome,
                                preco = preco
                            )
                        } ?: throw ProdutoInvalidaException()
                    } ?: throw ProdutoInvalidaException()
                } ?: throw ProdutoInvalidaException()
            } ?: throw ProdutoInvalidaException()

        val produtoResponse: ProdutoResponse = mapper.mapeiaProdutoResponse(produto)

        return ResponseEntity.ok(produtoResponse).let { response ->
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Produto cadastrado com sucesso!")
            response
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun atualizarProduto(
        @RequestBody @Valid produtoRequest: ProdutoRequest,
        @RequestParam("produto_id") produtoId: UUID
    ): ResponseEntity<ProdutoResponse> {

        LoggerHelper.logger.info(
            "${LoggerHelper.LOG_TAG_APP}: Solicitando atualização do produto ${produtoRequest.nome}"
        )

        val produto: Produto =
            useCase.atualizarProduto(
                produtoId = produtoId,
                nome = produtoRequest.nome,
                categoriaId = produtoRequest.categoriaId,
                preco = produtoRequest.preco,
                descricao = produtoRequest.descricao
            )

        val produtoResponse: ProdutoResponse = mapper.mapeiaProdutoResponse(produto)

        return ResponseEntity.ok(produtoResponse).let { response ->
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Produto atualizado com sucesso!")
            response
        }
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    fun deletarProdutoPeloId(
        @RequestParam id: UUID
    ): ResponseEntity<String> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Solicitando exclusão do produto")

        useCase.deletarProdutoPeloId(produtoId = id)

        return ResponseEntity.ok("Produto deletado com sucesso").let { response ->
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Produto deletado com sucesso!")
            response
        }
    }

}