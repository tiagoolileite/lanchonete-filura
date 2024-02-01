package br.com.fiap.lanchonetefilura.api.mapper.impl

import br.com.fiap.lanchonetefilura.api.mapper.CategoriaMapper
import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import org.springframework.stereotype.Component

@Component
class CategoriaMapperImpl : CategoriaMapper {
    override fun mapeiaCategoriaResponse(categoriaDTO: CategoriaDomainDTO): CategoriaResponse {
        return CategoriaResponse(
            categoriaDTO.id,
            categoriaDTO.descricao
        )
    }

    override fun mapeiaCategoriasResponse(categoriasDTO: List<CategoriaDomainDTO>): List<CategoriaResponse> {

        val categoriasResponse: ArrayList<CategoriaResponse> = arrayListOf()

        categoriasDTO.forEach { categoriaDTO ->
            categoriasResponse.add(mapeiaCategoriaResponse(categoriaDTO = categoriaDTO))
        }

        return categoriasResponse.toList()
    }
}