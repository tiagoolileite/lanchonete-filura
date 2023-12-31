package br.com.fiap.lanchonetefilura.adapter.driver.api.controller

import br.com.fiap.lanchonetefilura.adapter.driver.api.extensions.converterCategoriaModelToCategoriaResponse
import br.com.fiap.lanchonetefilura.adapter.driver.api.extensions.converterListaCategoriasModelToListaCategoriasResponse
import br.com.fiap.lanchonetefilura.adapter.driver.api.request.CategoriaRequestImpl
import br.com.fiap.lanchonetefilura.adapter.driver.api.response.CategoriaResponse
import br.com.fiap.lanchonetefilura.core.applications.usecases.CategoriaUseCase
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/categoria")
class CategoriaController (private val useCase: CategoriaUseCase) {

    @GetMapping("/categorias")
    fun getCategorias(): ResponseEntity<List<CategoriaResponse>> {

        logger.info("[FILURA]: Listando categorias")
        val categoriasResponse = useCase.getCategorias()?.converterListaCategoriasModelToListaCategoriasResponse()

        return ResponseEntity.ok(categoriasResponse).let {
            logger.info("[FILURA]: Categorias listadas com sucesso")
            it
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCategoria(@RequestBody @Valid categoriaRequest: CategoriaRequestImpl): ResponseEntity<CategoriaResponse> {

        logger.info("[FILURA]: Salvando categoria")
        val categoriaResponse =
            useCase.saveCategoria(categoriaRequest = categoriaRequest)?.converterCategoriaModelToCategoriaResponse()

        return ResponseEntity.ok(categoriaResponse).let {
            logger.info("[FILURA]: Categoria Salva com sucesso!")
            it
        }
    }
}