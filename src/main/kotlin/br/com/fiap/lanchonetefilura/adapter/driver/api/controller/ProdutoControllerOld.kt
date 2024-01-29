package br.com.fiap.lanchonetefilura.adapter.driver.api.controller

import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.core.applications.usecases.ProdutoUseCaseOld
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

/*
@RestController
@RequestMapping("api/produto")
class ProdutoControllerOld (private val produtoUseCaseOld: ProdutoUseCaseOld, */
/*private val categoriaUseCase: CategoriaUseCaseOld*//*
) {

    */
/*@GetMapping("/produtos")
    @ResponseStatus(HttpStatus.OK)
    fun getProdutos(): ResponseEntity<List<ProdutoResponse>> {

        logger.info("[FILURA]: Listando produtos")
        val produtos = produtoUseCaseOld.getProdutos()

        //val produtosResponse = produtos?.converterListaProdutosModelToListaProdutosResponse()

        return ResponseEntity.ok(produtosResponse).let { response ->
            logger.info("[FILURA]: Busca por produtos realizada com sucesso")
            response
        }
    }*//*


    */
/*@GetMapping("/produtos/categoria")
    @ResponseStatus(HttpStatus.OK)
    fun getProdutosByCategoria(
        @RequestParam("categoria_id") categoriaId: UUID
    ): ResponseEntity<List<ProdutoResponse>> {

        logger.info("[FILURA]: Iniciando Busca de produtos por categoria")
        val produtos = produtoUseCaseOld.getProdutosByCategoria(categoriaId = categoriaId)

        val produtosResponse = produtos?.converterListaProdutosModelToListaProdutosResponse()

        return ResponseEntity.ok(produtosResponse).let { response ->
            logger.info("[FILURA]: Busca de produtos por categoria realizada com sucesso!")
            response
        }
    }*//*


*/
/*    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun saveProduto(
        @RequestBody @Valid produtoRequest: ProdutoRequestImpl
    ): ResponseEntity<ProdutoResponse> {

        logger.info("[FILURA]: Salvando Produto")
        val categoria: CategoriaModel? = produtoRequest.categoriaId.let { categoriaUseCase.getCategoriaById(id = it) }

        val produto: ProdutoModel? =
            categoria?.let { produtoUseCase.saveProduto(produtoRequest)?.editCategoriaModel(categoriaModel = it) }

        val produtoResponse: ProdutoResponse = produto.converterProdutoModelToProdutoResponse()

        return ResponseEntity.ok(produtoResponse).let { response ->
            logger.info("[FILURA]: Produto salvo com sucesso")
            response
        }
    }*//*


*/
/*    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateProduto(
        @RequestBody @Valid produtoRequest: ProdutoRequestImpl,
        @RequestParam("produto_id") produtoId: UUID
    ): ResponseEntity<ProdutoResponse> {

        logger.info("[FILURA]: Atualização do produto iniciado")
        val categoriaModel: CategoriaModel? = produtoRequest.categoriaId.let { categoriaUseCase.getCategoriaById(id = it) }

        val produto: ProdutoModel? = categoriaModel?.let {
            produtoUseCase.updateProduto(
                produtoRequest = produtoRequest,
                produtoId = produtoId
            )?.editCategoriaModel(categoriaModel = it)
        }

        val produtoResponse = produto.converterProdutoModelToProdutoResponse()

        return ResponseEntity.ok(produtoResponse).let { response ->
            logger.info("[FILURA]: Produto atualizado com sucesso")
            response
        }
    }*//*


    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    fun deleteProduto(
        @RequestParam id: UUID
    ): ResponseEntity<String> {

        logger.info("[FILURA]: Apagando Produto")
        produtoUseCaseOld.deleteProduto(id = id)

        return ResponseEntity.ok("Produto deletado com sucesso").let { response ->
            logger.info("[FILURA]: Produto Apagado com sucesso")
            response
        }
    }
}
*/
