package br.com.fiap.lanchonetefilura.infra.adapter

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO

interface CategoriaAdapter {
    fun adaptarCategoriaParaCategoriaDto(categoria : Categoria) : CategoriaDTO

    fun adaptarCategoriaDtoParaCategoria(categoriaDTO : CategoriaDTO) : Categoria

    fun adaptarCategoriasDtoParaCategorias(categoriasDTO : List<CategoriaDTO>) : List<Categoria>
}