package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Produto
import java.util.*

interface ProdutoAdapter {
    fun adaptarProdutoParaProdutoDTO(produto: Produto, categoriaDTO: CategoriaDTOImpl?): ProdutoDTO

    fun adaptarProdutoParaProdutoDTOExistente(produto: Produto, id: UUID, categoriaDTO: CategoriaDTOImpl?): ProdutoDTO
}
