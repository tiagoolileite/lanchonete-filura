package br.com.fiap.lanchonetefilura.persistence.adapter

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.persistence.dto.CategoriaDTO

interface CategoriaAdapter {
    fun adaptarCategoriaParaCategoriaDto(categoria : Categoria) : CategoriaDTO

    fun adaptarCategoriaDtoParaCategoria(categoriaDTO : CategoriaDTO) : Categoria

    fun adaptarCategoriasDtoParaCategorias(categoriasDTO : List<CategoriaDTO>) : List<Categoria>
}