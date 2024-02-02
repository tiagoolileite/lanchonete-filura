package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.mapper.CategoriaMapper
import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaRequest
import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.domain.usecase.CategoriaUseCase
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.LOG_TAG_APP
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/categoria")
class CategoriaRestController(
    val useCase: CategoriaUseCase,
    val mapper: CategoriaMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarCategoria(@RequestBody @Valid categoriaRequest: CategoriaRequest): ResponseEntity<CategoriaResponse> {

        LoggerHelper.logger.info("${LOG_TAG_APP}: Solicitando cadastro categoria: ${categoriaRequest.descricao}")

        val categoria: Categoria? = categoriaRequest.descricao?.let { useCase.cadastrarCategoria(it) }

        val categoriaResponse: CategoriaResponse? = categoria?.let { mapper.mapeiaCategoriaResponse(categoria = it) }

        return ResponseEntity.ok(categoriaResponse).let { response ->
            LoggerHelper.logger.info("${LOG_TAG_APP}: Categoria ${response.body?.descricao} Salva com sucesso!")
            response
        }
    }

    @GetMapping("/categorias")
    fun listarCategorias(): ResponseEntity<List<CategoriaResponse>> {

        LoggerHelper.logger.info("${LOG_TAG_APP}: Solicitando listagem de categorias")

        val categorias: List<Categoria> =
            useCase.listarCategorias()

        val categoriasResponse: List<CategoriaResponse> =
            mapper.mapeiaCategoriasResponse(categorias = categorias)

        return ResponseEntity.ok(categoriasResponse).let { response ->
            LoggerHelper.logger.info("${LOG_TAG_APP}: Categorias listadas com sucesso")
            response
        }
    }
}