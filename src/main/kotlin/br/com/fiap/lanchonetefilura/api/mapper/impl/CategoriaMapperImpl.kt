package br.com.fiap.lanchonetefilura.api.mapper.impl

import br.com.fiap.lanchonetefilura.api.mapper.CategoriaMapper
import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import org.springframework.stereotype.Component

@Component
class CategoriaMapperImpl : CategoriaMapper {
    override fun mapeiaCategoriaResponse(categoria: Categoria): CategoriaResponse {
        return CategoriaResponse(
            id = categoria.id,
            descricao = categoria.descricao
        )
    }

    override fun mapeiaCategoriasResponse(categorias: List<Categoria>): List<CategoriaResponse> {
        return categorias.map { categoria: Categoria ->
            mapeiaCategoriaResponse(categoria)
        }
    }
}