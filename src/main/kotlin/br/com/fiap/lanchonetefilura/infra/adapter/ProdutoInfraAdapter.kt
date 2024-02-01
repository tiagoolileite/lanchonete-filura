package br.com.fiap.lanchonetefilura.infra.adapter

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.ProdutoDTOImpl

interface ProdutoInfraAdapter {
    fun adaptarProdutosDomainDtoEmDtoImpl(produtos : List<ProdutoDomainDTO>) : List<ProdutoDTOImpl>

}
