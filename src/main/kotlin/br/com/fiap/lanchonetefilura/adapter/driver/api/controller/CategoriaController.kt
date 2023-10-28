package br.com.fiap.lanchonetefilura.adapter.driver.api.controller

import br.com.fiap.lanchonetefilura.adapter.driver.api.request.CategoriaRequest
import br.com.fiap.lanchonetefilura.core.applications.usecases.CategoriaUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
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
    fun findAllCategorias(): ResponseEntity<ArrayList<CategoriaModel>> {
        return ResponseEntity.ok(useCase.findAll())
    }

    @PostMapping
    fun saveCategoria(@RequestBody @Valid categoria: CategoriaRequest): ResponseEntity<CategoriaModel> {
        return ResponseEntity.ok(useCase.save(categoria))
    }
}