package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.domain.controller.CategoriaController
import br.com.fiap.lanchonetefilura.domain.usecase.CategoriaUseCase
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import org.springframework.stereotype.Component

@Component
class CategoriaControllerImpl(
    val useCase: CategoriaUseCase,
    val adapter: CategoriaAdapter
) : CategoriaController {
    override fun cadastrarCategoria(descricao: String): CategoriaResponse {

        val categoriaDTO: CategoriaDTO = useCase.cadastrarCategoria(descricao)

        return adapter.adaptarCategoria(categoriaDTO)
    }

    override fun listarCategorias(): List<CategoriaResponse> {

        val categoriasDTO: List<CategoriaDTO> = useCase.listarCategorias()

        return adapter.adaptarListaDeCategoria(categoriasDTO)
    }
}