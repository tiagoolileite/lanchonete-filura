package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaRequest
import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.controller.CategoriaController
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/categoria")
class CategoriaRestController(val controller: CategoriaController) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarCaregoria(@RequestBody @Valid categoriaRequest: CategoriaRequest): ResponseEntity<CategoriaResponse> {

        LoggerHelper.logger.info("[FILURA]: Salvando categoria: ${categoriaRequest.descricao}")
        val categoriaResponse: CategoriaResponse? =
            categoriaRequest.descricao?.let { controller.cadastrarCategoria(it) }

        return ResponseEntity.ok(categoriaResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Categoria ${categoriaRequest.descricao} Salva com sucesso!")
            response
        }
    }

    @GetMapping("/categorias")
    fun listarCategorias(): ResponseEntity<List<CategoriaResponse>> {

        LoggerHelper.logger.info("[FILURA]: Listando categorias")
        val categoriasResponse: List<CategoriaResponse> =
            controller.listarCaregorias()

        return ResponseEntity.ok(categoriasResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Categorias listadas com sucesso")
            response
        }
    }
}