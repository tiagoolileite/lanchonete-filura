package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDomainDTOImpl
import java.util.*

interface CategoriaUseCase {
    fun cadastrarCategoria(descricao: String?): CategoriaDomainDTO

    fun listarCategorias(): List<CategoriaDomainDTO>

    fun buscarCategoriaPeloId(categoriaId: UUID): CategoriaDomainDTOImpl?
}