package br.com.fiap.lanchonetefilura.api.mapper

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO

interface CategoriaMapper {
    fun mapeiaCategoriaResponse(categoriaDomainDTO: CategoriaDomainDTO): CategoriaResponse?

    fun mapeiaCategoriasResponse(categoriasDomainDTO: List<CategoriaDomainDTO>): List<CategoriaResponse>
}