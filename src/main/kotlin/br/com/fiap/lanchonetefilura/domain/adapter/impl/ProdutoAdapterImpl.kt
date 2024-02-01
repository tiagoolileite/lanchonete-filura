package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.domain.adapter.ProdutoAdapter
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.domain.dto.impl.ProdutoDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Produto
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoAdapterImpl : ProdutoAdapter {
    override fun adaptarProdutoParaProdutoDTO(produto: Produto, categoriaDTO: CategoriaDTOImpl?): ProdutoDTO {
        return ProdutoDTOImpl(
            nome = produto.nome,
            descricao = produto.descricao,
            preco = produto.preco,
            categoria = categoriaDTO
        )
    }

    override fun adaptarProdutoParaProdutoDTOExistente(
        produto: Produto,
        id: UUID,
        categoriaDTO: CategoriaDTOImpl?
    ): ProdutoDTO {
        return ProdutoDTOImpl(
            id = id,
            nome = produto.nome,
            descricao = produto.descricao,
            preco = produto.preco,
            categoria = categoriaDTO
        )
    }

}