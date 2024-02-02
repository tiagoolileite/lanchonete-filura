package br.com.fiap.lanchonetefilura.persistence.repository

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import java.util.*

interface CategoriaRepository {
    fun cadastrarCategoria(categoria: Categoria): Categoria

    fun listarCategorias(): List<Categoria>

    fun buscarCategoriaPeloId(categoriaId: UUID): Optional<Categoria>

}