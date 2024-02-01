package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO

interface CategoriaController {
    fun cadastrarCategoria(descricao: String?): CategoriaDTO

    fun listarCategorias(): List<CategoriaDTO>
}