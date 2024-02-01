package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Categoria

interface CategoriaAdapter {

    fun adaptarCategoriaParaCategoriaDto(categoria: Categoria): CategoriaDomainDTOImpl
}