package br.com.fiap.lanchonetefilura.core.domain.request

import java.util.*

interface ProdutoRequest {
     val nome: String
     val descricao: String
     val preco: Double
     val categoriaId: UUID
}