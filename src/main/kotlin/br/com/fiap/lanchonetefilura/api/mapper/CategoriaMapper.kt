package br.com.fiap.lanchonetefilura.api.mapper

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO

interface CategoriaMapper {
    fun mapeiaCategoriaResponse(categoriaDTO: CategoriaDTO): CategoriaResponse?

    fun mapeiaCategoriasResponse(categoriasDTO: List<CategoriaDTO>): List<CategoriaResponse>
}