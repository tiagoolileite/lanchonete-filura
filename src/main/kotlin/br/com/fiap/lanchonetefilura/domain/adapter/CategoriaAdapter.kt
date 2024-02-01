package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO

interface CategoriaAdapter {

    fun adaptarCategoriaParaCategoriaDto(categoria: Categoria): CategoriaDomainDTOImpl

    fun adaptarCategoriaDtoParaDomainDto(categoriaDTO: CategoriaDTO): CategoriaDomainDTOImpl

    fun adaptarCategoriasDtoParaDomainDto(categoriasDTO: List<CategoriaDTO>): List<CategoriaDomainDTO>

    fun adaptarCategoriaDomainDtoParaCategoria(categoria : CategoriaDomainDTOImpl?) : Categoria?
}