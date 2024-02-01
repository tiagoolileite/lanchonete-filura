package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import java.util.*

interface CategoriaRepository {
    fun cadastrarCategoria(categoriaDomainDTO: CategoriaDomainDTO): CategoriaDomainDTO

    fun listarCategorias(): List<CategoriaDomainDTO>

    fun buscarCategoriaPeloId(categoriaId: UUID): Optional<CategoriaDomainDTO>

}