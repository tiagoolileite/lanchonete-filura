package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO

interface CategoriaUseCase {
    fun cadastrarCategoria(descricao: String): CategoriaDTO
    fun listarCategorias(): List<CategoriaDTO>
}