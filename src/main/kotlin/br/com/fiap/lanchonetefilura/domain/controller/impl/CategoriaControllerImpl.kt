package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.controller.CategoriaController
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoriaControllerImpl : CategoriaController {
    override fun cadastrarCategoria(descricao: String?): CategoriaResponse {
        return CategoriaResponse(UUID.randomUUID(), "Teste")
    }

    override fun listarCaregorias(): List<CategoriaResponse> {
        val categoria1 = CategoriaResponse(UUID.randomUUID(), "Test1")
        val categoria2 = CategoriaResponse(UUID.randomUUID(), "Test2")
        val categoria3 = CategoriaResponse(UUID.randomUUID(), "Test3")
        val categoria4 = CategoriaResponse(UUID.randomUUID(), "Test4")

        return listOf(categoria1, categoria2, categoria3, categoria4)
    }
}