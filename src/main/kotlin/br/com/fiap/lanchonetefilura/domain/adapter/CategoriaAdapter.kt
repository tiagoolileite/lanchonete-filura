package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Categoria

interface CategoriaAdapter {
    fun adaptarCategoria(categoriaDTO: CategoriaDTO?): CategoriaResponse

    fun adaptarListaDeCategoria(categoriasDTO: List<CategoriaDTO?>): List<CategoriaResponse>

    fun adaptarCategoriaParaCategoriaDto(categoria: Categoria): CategoriaDTOImpl
}