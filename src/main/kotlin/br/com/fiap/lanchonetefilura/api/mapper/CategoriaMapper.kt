package br.com.fiap.lanchonetefilura.api.mapper

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.entity.Categoria

interface CategoriaMapper {
    fun mapeiaCategoriaResponse(categoria: Categoria): CategoriaResponse

    fun mapeiaCategoriasResponse(categorias: List<Categoria>): List<CategoriaResponse>
}