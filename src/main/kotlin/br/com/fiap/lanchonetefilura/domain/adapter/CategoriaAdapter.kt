package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO

interface CategoriaAdapter {
    fun adaptarCategoria(categoriaDTO: CategoriaDTO?): CategoriaResponse

    fun adaptarListaDeCategoria(categoriasDTO: List<CategoriaDTO?>): List<CategoriaResponse>
}