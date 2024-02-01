package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Categoria

interface CategoriaAdapter {
    fun adaptarCategoria(categoriaDTO: CategoriaDomainDTO?): CategoriaResponse

    fun adaptarListaDeCategoria(categoriasDTO: List<CategoriaDomainDTO?>): List<CategoriaResponse>

    fun adaptarCategoriaParaCategoriaDto(categoria: Categoria): CategoriaDomainDTOImpl
}