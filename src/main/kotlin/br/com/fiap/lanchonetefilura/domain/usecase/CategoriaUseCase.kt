package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import java.util.*

interface CategoriaUseCase {
    fun cadastrarCategoria(descricao: String?): CategoriaDTO

    fun listarCategorias(): List<CategoriaDTO>

    fun buscarCategoriaPeloId(categoriaId: UUID): CategoriaDTOImpl
}