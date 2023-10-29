package br.com.fiap.lanchonetefilura.adapter.driver.api.controller

import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ProdutoRequest
import br.com.fiap.lanchonetefilura.core.applications.usecases.CategoriaUseCase
import br.com.fiap.lanchonetefilura.core.applications.usecases.ProdutoUseCase
import br.com.fiap.lanchonetefilura.core.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("api/produto")
class ProdutoController (private val produtoUseCase: ProdutoUseCase, private val categoriaUseCase: CategoriaUseCase) {

    @GetMapping("/produtos")
    @ResponseStatus(HttpStatus.OK)
    fun findAllProdutos(): ResponseEntity<ArrayList<ProdutoModel>> {
        return ResponseEntity.ok(produtoUseCase.findAllProdutos())
    }

    @GetMapping("/produtos/categoria")
    @ResponseStatus(HttpStatus.OK)
    fun findProdutosByCategoria(@RequestParam id: UUID): ResponseEntity<ArrayList<ProdutoModel>> {

        val produto = produtoUseCase.findProdutosByCategoria(id)

        return ResponseEntity.ok(produto)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun saveProduto(
        @RequestBody @Valid produtoRequest: ProdutoRequest
    ): ResponseEntity<ProdutoModel> {

        val categoria: CategoriaDTO? = categoriaUseCase.getCategoriaById(produtoRequest.categoriaId)

        val produto: ProdutoModel? = produtoUseCase.saveProduto(produtoRequest, categoria)

        return ResponseEntity.ok(produto)
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateProduto(
        @RequestBody @Valid produtoRequest: ProdutoRequest,
        @RequestParam id: UUID
    ): ResponseEntity<ProdutoModel> {

        //val categoria: CategoriaModel? = null /* categoriaUseCase.getCategoriaById(produtoRequest.categoriaId)*/

        val produto: ProdutoModel? = produtoUseCase.updateProduto(produtoRequest, id, CategoriaModel())

        return ResponseEntity.ok(produto)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    fun deleteProduto(
        @RequestParam id: UUID
    ): ResponseEntity<String> {
        produtoUseCase.deleteProduto(id)

        return ResponseEntity.ok("Produto deletado com sucesso")
    }
}