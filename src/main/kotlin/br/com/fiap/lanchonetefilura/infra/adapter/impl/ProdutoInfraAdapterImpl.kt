package br.com.fiap.lanchonetefilura.infra.adapter.impl

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.infra.adapter.CategoriaInfraAdapter
import br.com.fiap.lanchonetefilura.infra.adapter.ProdutoInfraAdapter
import br.com.fiap.lanchonetefilura.infra.dto.impl.ProdutoDTOImpl
import org.springframework.stereotype.Component

@Component
class ProdutoInfraAdapterImpl (
    private val categoriaInfraAdapter: CategoriaInfraAdapter
) : ProdutoInfraAdapter {
    override fun adaptarProdutosDomainDtoEmDtoImpl(produtos : List<ProdutoDomainDTO>) : List<ProdutoDTOImpl> {
        return produtos.map { produtoDomainDTO ->
            ProdutoDTOImpl(
                id = produtoDomainDTO.id,
                nome = produtoDomainDTO.nome,
                descricao = produtoDomainDTO.descricao,
                preco = produtoDomainDTO.preco,
                categoria = categoriaInfraAdapter.adaptarCategoriaDomainDtoEmDtoImpl(produtoDomainDTO.categoria)
            )
        }
    }
}