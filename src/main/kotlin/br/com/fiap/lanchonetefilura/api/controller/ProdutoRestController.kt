package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoRequest
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.core.domain.request.ProdutoRequestOld
import br.com.fiap.lanchonetefilura.domain.controller.ProdutoController
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/produto")
class ProdutoRestController(val controller: ProdutoController) {

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
    @ResponseStatus(HttpStatus.OK)
    fun saveProduto(
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

}