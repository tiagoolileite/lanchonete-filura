package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.mapper.CategoriaMapper
import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaRequest
import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.controller.CategoriaController
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.LOG_TAG_APP
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/categoria")
class CategoriaRestController(
    val controller: CategoriaController,
    val mapper: CategoriaMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarCategoria(@RequestBody @Valid categoriaRequest: CategoriaRequest): ResponseEntity<CategoriaResponse> {

        LoggerHelper.logger.info("${LOG_TAG_APP}: Solicitando cadastro categoria: ${categoriaRequest.descricao}")

        val categoriaDTO: CategoriaDomainDTO = controller.cadastrarCategoria(descricao = categoriaRequest.descricao)

        val categoriaResponse: CategoriaResponse? = mapper.mapeiaCategoriaResponse(categoriaDTO)

        return ResponseEntity.ok(categoriaResponse).let { response ->
            LoggerHelper.logger.info("${LOG_TAG_APP}: Categoria ${categoriaRequest.descricao} Salva com sucesso!")
            response
        }
    }

    @GetMapping("/categorias")
    fun listarCategorias(): ResponseEntity<List<CategoriaResponse>> {

        LoggerHelper.logger.info("${LOG_TAG_APP}: Solicitando listagem de categorias")

        val categoriasDTO: List<CategoriaDomainDTO> =
            controller.listarCategorias()

        val categoriasResponse: List<CategoriaResponse> =
            mapper.mapeiaCategoriasResponse(categoriasDTO)

        return ResponseEntity.ok(categoriasResponse).let { response ->
            LoggerHelper.logger.info("${LOG_TAG_APP}: Categorias listadas com sucesso")
            response
        }
    }
}