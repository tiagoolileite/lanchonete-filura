package br.com.fiap.lanchonetefilura.infra.adapter.impl

import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.infra.adapter.ProdutoAdapter
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import org.springframework.stereotype.Component

@Component
class ProdutoAdapterImpl : ProdutoAdapter {
    override fun adaptarProdutosDTOParaProdutos(produtosDTO : List<ProdutoDTO>) : List<Produto> {
        TODO("Not yet implemented")
    }

    override fun adaptarProdutoParaProdutoDTO(produto : Produto) : ProdutoDTO {
        TODO("Not yet implemented")
    }

    override fun adaptarProdutoDTOParaProduto(produtoDTO : ProdutoDTO) : Produto {
        TODO("Not yet implemented")
    }
}