package br.com.fiap.lanchonetefilura.domain.usecase

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import java.util.*

interface CategoriaUseCase {
    fun cadastrarCategoria(descricao: String): Categoria

    fun listarCategorias(): List<Categoria>

    fun buscarCategoriaPeloId(categoriaId: UUID): Categoria?
}