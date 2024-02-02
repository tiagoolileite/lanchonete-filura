package br.com.fiap.lanchonetefilura.domain.adapter

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import java.util.*

interface ProdutoAdapter {
    fun adaptarProdutoParaProdutoDTO(produto: Produto, categoriaDomainDTO: CategoriaDomainDTOImpl?): ProdutoDomainDTO

    fun adaptarProdutoParaProdutoDTOExistente(produto: Produto, id: UUID, categoriaDomainDTO: CategoriaDomainDTOImpl?): ProdutoDomainDTO

    fun adaptarProdutosDtoParaDomainDto(produtosDTO: List<ProdutoDTO>): List<ProdutoDomainDTO>

    fun adaptarProdutoDtoParaDomainDto(produtoDTO: ProdutoDTO): ProdutoDomainDTO

    fun adaptarProdutoDtoParaOptionalDomainDto(produtoOptionalDTO: Optional<ProdutoDTO>): Optional<ProdutoDomainDTO>

    fun adaptarProdutosMutableDtoParaMutableDomainDto(produtosDTO: MutableList<ProdutoDTO>): MutableList<ProdutoDomainDTO>
}
