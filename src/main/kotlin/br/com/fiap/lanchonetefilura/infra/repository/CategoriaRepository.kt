package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import java.util.*

interface CategoriaRepository {
    fun cadastrarCategoria(categoriaDTO: CategoriaDTOImpl): CategoriaDTO

    fun listarCategorias(): List<CategoriaDTO>

    fun buscarCategoriaPeloId(categoriaId: UUID): Optional<CategoriaDTO>

}