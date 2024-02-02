package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO

interface CategoriaController {
    fun cadastrarCategoria(descricao: String?): CategoriaDomainDTO

    fun listarCategorias(): List<CategoriaDomainDTO>
}