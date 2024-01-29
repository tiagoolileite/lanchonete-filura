package br.com.fiap.lanchonetefilura.core.domain.request

import java.util.*

interface ProdutoRequestOld {
     val nome: String
     val descricao: String
     val preco: Double
     val categoriaId: UUID
}