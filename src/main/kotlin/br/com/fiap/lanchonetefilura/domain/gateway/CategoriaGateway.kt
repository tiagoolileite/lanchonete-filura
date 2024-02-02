package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import java.util.*

interface CategoriaGateway {
    fun cadastrarCategoria(categoria: Categoria): Categoria

    fun listarCategorias(): List<Categoria>

    fun buscarCategoriaPeloId(categoriaId: UUID): Optional<Categoria>
}
