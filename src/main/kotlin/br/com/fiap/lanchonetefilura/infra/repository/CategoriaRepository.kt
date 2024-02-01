package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import java.util.*

interface CategoriaRepository {
    fun cadastrarCategoria(categoriaDomainDTO: CategoriaDomainDTO): CategoriaDTO

    fun listarCategorias(): List<CategoriaDTO>

    fun buscarCategoriaPeloId(categoriaId: UUID): Optional<CategoriaDTO>

}