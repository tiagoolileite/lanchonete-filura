package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO

interface CategoriaGateway {
    fun cadastrarCategoria(descricao: String): CategoriaDTO
    fun listarCategorias(): List<CategoriaDTO>

}
