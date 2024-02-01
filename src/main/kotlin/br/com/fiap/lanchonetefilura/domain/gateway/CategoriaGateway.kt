package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import java.util.*

interface CategoriaGateway {
    fun cadastrarCategoria(categoriaDTO: CategoriaDTOImpl): CategoriaDTO

    fun listarCategorias(): List<CategoriaDTO>

    fun buscarCategoriaPeloId(categoriaId: UUID): CategoriaDTOImpl
}
