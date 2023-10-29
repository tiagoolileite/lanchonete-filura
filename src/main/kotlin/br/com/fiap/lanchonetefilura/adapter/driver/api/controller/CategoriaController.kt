package br.com.fiap.lanchonetefilura.adapter.driver.api.controller

import br.com.fiap.lanchonetefilura.adapter.driver.api.extensions.converterCategoriaDtoToCategoriaResponse
import br.com.fiap.lanchonetefilura.adapter.driver.api.extensions.converterListaCategoriasDtoToListaCategoriasResponse
import br.com.fiap.lanchonetefilura.adapter.driver.api.request.CategoriaRequestImpl
import br.com.fiap.lanchonetefilura.adapter.driver.api.response.CategoriaResponse
import br.com.fiap.lanchonetefilura.core.applications.usecases.CategoriaUseCase
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("api/categoria")
class CategoriaController (private val useCase: CategoriaUseCase) {

    @GetMapping("/categorias")
    fun getCategorias(): ResponseEntity<List<CategoriaResponse>> {

        logger.info("[FILURA]: Listando categorias")
        val categoriasResponse = useCase.getCategorias()?.converterListaCategoriasDtoToListaCategoriasResponse()

        return ResponseEntity.ok(categoriasResponse).let {
            logger.info("[FILURA]: Categorias listadas com sucesso")
            it
        }
    }

    @PostMapping
    fun saveCategoria(@RequestBody @Valid categoriaRequest: CategoriaRequestImpl): ResponseEntity<CategoriaResponse> {

        logger.info("[FILURA]: Salvando categoria")
        val categoriaResponse =
            useCase.saveCategoria(categoriaRequest = categoriaRequest)?.converterCategoriaDtoToCategoriaResponse()

        return ResponseEntity.ok(categoriaResponse).let {
            logger.info("[FILURA]: Categoria Salva com sucesso!")
            it
        }
    }
}