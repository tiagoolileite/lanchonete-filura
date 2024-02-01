package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.mapper.ProdutoMapper
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoRequest
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.controller.ProdutoController
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/produto")
class ProdutoRestController(
    val controller: ProdutoController,
    val mapper: ProdutoMapper
) {

    @GetMapping("/produtos")
    @ResponseStatus(HttpStatus.OK)
    fun listarProdutos(): ResponseEntity<List<ProdutoResponse>> {

        LoggerHelper.logger.info("[FILURA]: Listando produtos")
        val produtosResponse: List<ProdutoResponse>  =
            controller.listarProdutos()

        return ResponseEntity.ok(produtosResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Busca por produtos realizada com sucesso")
            response
        }
    }

    @GetMapping("/produtos/categoria")
    @ResponseStatus(HttpStatus.OK)
    fun listarProdutosPorCategoria(
        @RequestParam("categoria_id") categoriaId: UUID
    ): ResponseEntity<List<ProdutoResponse>> {

        LoggerHelper.logger.info("[FILURA]: Iniciando Busca de produtos por categoria")
        val produtosResponse: List<ProdutoResponse> =
            controller.listarProdutosPorCategoria(categoriaId = categoriaId)

        return ResponseEntity.ok(produtosResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Busca de produtos por categoria realizada com sucesso!")
            response
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarProduto(
        @RequestBody @Valid produtoRequest: ProdutoRequest
    ): ResponseEntity<ProdutoResponse> {

        LoggerHelper.logger.info("[FILURA]: Salvando Produto")

        LoggerHelper.logger.info(
            "[FILURA]: Requisição: ${produtoRequest.nome}\nID_CATEGORIA: ${produtoRequest.categoriaId}"
        )

        val produtoResponse: ProdutoResponse = controller.cadastrarProduto(
            categoriaId = produtoRequest.categoriaId,
            descricao = produtoRequest.descricao,
            nome = produtoRequest.nome,
            preco = produtoRequest.preco
        )

        return ResponseEntity.ok(produtoResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Produto salvo com sucesso")
            response
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun atualizarProduto(
        @RequestBody @Valid produtoRequest: ProdutoRequest,
        @RequestParam("produto_id") produtoId: UUID
    ): ResponseEntity<ProdutoResponse> {

        LoggerHelper.logger.info("[FILURA]: Atualização do produto iniciado")
        val produtoResponse: ProdutoResponse? =
            controller.atualizaProduto(
                id = produtoId,
                nome = produtoRequest.nome,
                categoriaId = produtoRequest.categoriaId,
                preco = produtoRequest.preco,
                descricao = produtoRequest.descricao
            )

        return ResponseEntity.ok(produtoResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Produto atualizado com sucesso")
            response
        }
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    fun deletarProdutoPeloId(
        @RequestParam id: UUID
    ): ResponseEntity<String> {

        LoggerHelper.logger.info("[FILURA]: Apagando Produto")
        controller.deletarProdutoPeloId(id = id)

        return ResponseEntity.ok("Produto deletado com sucesso").let { response ->
            LoggerHelper.logger.info("[FILURA]: Produto Apagado com sucesso")
            response
        }
    }

}