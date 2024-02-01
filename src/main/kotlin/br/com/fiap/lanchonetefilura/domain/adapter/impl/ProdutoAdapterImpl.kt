package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.domain.adapter.ProdutoAdapter
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.ProdutoDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.infra.dto.impl.CategoriaDTOImpl
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoAdapterImpl : ProdutoAdapter {
    override fun adaptarProdutoParaProdutoDTO(produto: Produto, categoriaDTO: CategoriaDTOImpl?): ProdutoDomainDTO {
        return ProdutoDomainDTOImpl(
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
    ): ProdutoDomainDTO {
        return ProdutoDomainDTOImpl(
            id = id,
            nome = produto.nome,
            descricao = produto.descricao,
            preco = produto.preco,
            categoria = categoriaDTO
        )
    }

}