package br.com.fiap.lanchonetefilura.api.mapper.impl

import br.com.fiap.lanchonetefilura.api.mapper.CategoriaMapper
import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import org.springframework.stereotype.Component

@Component
class CategoriaMapperImpl : CategoriaMapper {
    override fun mapeiaCategoriaResponse(categoriaDomainDTO: CategoriaDomainDTO): CategoriaResponse {
        return CategoriaResponse(
            id = categoriaDomainDTO.id,
            descricao = categoriaDomainDTO.descricao
        )
    }

    override fun mapeiaCategoriasResponse(categoriasDomainDTO: List<CategoriaDomainDTO>): List<CategoriaResponse> {

        val categoriasResponse: ArrayList<CategoriaResponse> = arrayListOf()

        categoriasDomainDTO.forEach { categoriaDTO ->
            categoriasResponse.add(mapeiaCategoriaResponse(categoriaDomainDTO = categoriaDTO))
        }

        return categoriasResponse.toList()
    }
}