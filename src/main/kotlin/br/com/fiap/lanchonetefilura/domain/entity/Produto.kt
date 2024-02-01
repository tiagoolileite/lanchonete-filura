package br.com.fiap.lanchonetefilura.domain.entity

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO

class Produto (
    var nome: String? = null,
    var descricao: String? = null,
    var preco: Double? = null,
    var categoria: CategoriaDTO? = null
)
