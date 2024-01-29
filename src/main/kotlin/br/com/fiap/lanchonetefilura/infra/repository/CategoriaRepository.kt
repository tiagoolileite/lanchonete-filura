package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO

interface CategoriaRepository {
    fun cadastrarCategoria(descricao: String): CategoriaDTO

    fun listarCategorias(): List<CategoriaDTO>

}