package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.domain.controller.CategoriaController
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.domain.usecase.CategoriaUseCase
import org.springframework.stereotype.Component

@Component
class CategoriaControllerImpl(
    val useCase: CategoriaUseCase
) : CategoriaController {
    override fun cadastrarCategoria(descricao: String?): CategoriaDTO {
        return useCase.cadastrarCategoria(descricao = descricao)
    }

    override fun listarCategorias(): List<CategoriaDTO> {
        return useCase.listarCategorias()
    }
}