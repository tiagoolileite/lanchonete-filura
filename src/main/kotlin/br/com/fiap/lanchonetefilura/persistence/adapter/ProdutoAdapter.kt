package br.com.fiap.lanchonetefilura.persistence.adapter

import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.persistence.dto.ProdutoDTO

interface ProdutoAdapter {
    fun adaptarProdutosDTOParaProdutos(produtosDTO : List<ProdutoDTO>) : List<Produto>
    
    fun adaptarProdutoParaProdutoDTO(produto : Produto) : ProdutoDTO

    fun adaptarProdutoDTOParaProduto(produtoDTO : ProdutoDTO) : Produto

    fun adaptarProdutosParaProdutosDTO(produtos : List<Produto>) : List<ProdutoDTO>

}
