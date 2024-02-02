package br.com.fiap.lanchonetefilura.domain.entity

import java.util.*

class Produto (
    val id: UUID = UUID.randomUUID(),
    var nome: String,
    var descricao: String,
    var preco: Double,
    var categoria: Categoria
)
