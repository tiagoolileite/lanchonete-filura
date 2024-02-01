package br.com.fiap.lanchonetefilura.api.mapper

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO

interface CategoriaMapper {
    fun mapeiaCategoriaResponse(categoriaDTO: CategoriaDomainDTO): CategoriaResponse?

    fun mapeiaCategoriasResponse(categoriasDTO: List<CategoriaDomainDTO>): List<CategoriaResponse>
}