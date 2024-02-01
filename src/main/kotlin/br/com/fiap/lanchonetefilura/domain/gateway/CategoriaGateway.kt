package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import java.util.*

interface CategoriaGateway {
    fun cadastrarCategoria(categoriaDomainDTO: CategoriaDomainDTO): CategoriaDomainDTO

    fun listarCategorias(): List<CategoriaDomainDTO>

    fun buscarCategoriaPeloId(categoriaId: UUID): Optional<CategoriaDomainDTO>
}
