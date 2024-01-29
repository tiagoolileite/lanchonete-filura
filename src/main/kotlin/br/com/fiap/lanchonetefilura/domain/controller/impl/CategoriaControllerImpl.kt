package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.controller.CategoriaController
import br.com.fiap.lanchonetefilura.domain.gateway.CategoriaGateway
import br.com.fiap.lanchonetefilura.domain.usecase.CategoriaUseCase
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import org.springframework.stereotype.Component

@Component
class CategoriaControllerImpl(
    val useCase: CategoriaUseCase
) : CategoriaController {
    override fun cadastrarCategoria(descricao: String): CategoriaResponse {

        val categoriaDTO: CategoriaDTO = useCase.cadastrarCategoria(descricao)

        return CategoriaResponse(categoriaDTO.id, categoriaDTO.descricao)
    }

    override fun listarCaregorias(): List<CategoriaResponse> {

        val categoriasDTO: List<CategoriaDTO> = useCase.listarCategorias()

        val categoriasResponse: ArrayList<CategoriaResponse> = arrayListOf()

        categoriasDTO.forEach {
            categoriasResponse.add(CategoriaResponse(id = it.id, descricao = it.descricao))
        }

        return categoriasResponse.toList()
    }
}