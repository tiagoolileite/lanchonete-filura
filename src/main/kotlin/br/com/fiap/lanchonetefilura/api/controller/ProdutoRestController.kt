package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.controller.ProdutoController
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

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

}