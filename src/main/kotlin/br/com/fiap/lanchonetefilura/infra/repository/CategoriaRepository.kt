package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import java.util.*

interface CategoriaRepository {
    fun cadastrarCategoria(descricao: String): CategoriaDTO

    fun listarCategorias(): List<CategoriaDTO>

    fun buscarCategoriaPeloId(categoriaId: UUID): CategoriaDTO

}