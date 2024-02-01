package br.com.fiap.lanchonetefilura.api.mapper.impl

import br.com.fiap.lanchonetefilura.api.mapper.CategoriaMapper
import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO
import org.springframework.stereotype.Component

@Component
class CategoriaMapperImpl : CategoriaMapper {
    override fun mapeiaCategoriaResponse(categoriaDTO: CategoriaDTO): CategoriaResponse {
        return CategoriaResponse(
            categoriaDTO.id,
            categoriaDTO.descricao
        )
    }

    override fun mapeiaCategoriasResponse(categoriasDTO: List<CategoriaDTO>): List<CategoriaResponse> {

        val categoriasResponse: ArrayList<CategoriaResponse> = arrayListOf()

        categoriasDTO.forEach { categoriaDTO ->
            val categoriaResponse = CategoriaResponse(
                categoriaDTO.id,
                categoriaDTO.descricao
            )

            categoriasResponse.add(categoriaResponse)
        }

        return categoriasResponse.toList()
    }
}