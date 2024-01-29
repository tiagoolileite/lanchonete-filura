package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import java.util.*

interface CategoriaGateway {
    fun cadastrarCategoria(descricao: String): CategoriaDTO
    fun listarCategorias(): List<CategoriaDTO>

    fun buscarCategoriaPeloId(categoriaId: UUID?): CategoriaDTO?

}
