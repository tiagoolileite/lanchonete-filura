package br.com.fiap.lanchonetefilura.domain.controller

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse

interface CategoriaController {
    fun cadastrarCategoria(descricao: String?): CategoriaResponse
    fun listarCaregorias(): List<CategoriaResponse>
}