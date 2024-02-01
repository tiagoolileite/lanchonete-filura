package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import java.util.*

interface ProdutoGateway {
    fun listarProdutos(): List<ProdutoDomainDTO>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDomainDTO>

    fun cadastrarProduto(
        produtoDTO: ProdutoDomainDTO
    ): ProdutoDomainDTO

    fun buscarProdutoPeloId(id: UUID): Optional<ProdutoDomainDTO>

    fun atualizarProduto(produtoDTO: ProdutoDomainDTO): ProdutoDomainDTO

    fun deletarProdutoPeloId(produtoId: UUID)

    fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<ProdutoDomainDTO>
}
