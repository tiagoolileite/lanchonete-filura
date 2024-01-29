package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.core.domain.model.ProdutoModel
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import java.util.*

interface ProdutoRepository {

    fun listarProdutos(): List<ProdutoDTO>
}