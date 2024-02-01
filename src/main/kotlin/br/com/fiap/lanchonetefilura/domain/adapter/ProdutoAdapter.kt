package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.infra.dto.impl.CategoriaDTOImpl
import java.util.*

interface ProdutoAdapter {
    fun adaptarProdutoParaProdutoDTO(produto: Produto, categoriaDTO: CategoriaDTOImpl?): ProdutoDomainDTO

    fun adaptarProdutoParaProdutoDTOExistente(produto: Produto, id: UUID, categoriaDTO: CategoriaDTOImpl?): ProdutoDomainDTO
}
