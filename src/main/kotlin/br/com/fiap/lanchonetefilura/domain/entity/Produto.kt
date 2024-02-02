package br.com.fiap.lanchonetefilura.domain.entity

import java.util.*

class Produto (
    var id: UUID = UUID.randomUUID(),
    var nome: String,
    var descricao: String,
    var preco: Double,
    var categoria: Categoria
) {

    init {
        check(preco >= 0.0) {
            throw Exception("Preço não pode ser negativo")
        }
    }
}