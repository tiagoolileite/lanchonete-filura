package br.com.fiap.lanchonetefilura.core.domain.request

import java.util.UUID

interface ProdutoRequest {
     val nome: String
     val descricao: String
     val preco: Double
     val categoriaId: UUID
}