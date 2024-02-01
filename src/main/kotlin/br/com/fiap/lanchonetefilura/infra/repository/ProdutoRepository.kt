package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import java.util.*

interface ProdutoRepository {

    fun listarProdutos(): List<ProdutoDomainDTO>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDomainDTO>

    fun cadastrarOuAtualizarProduto(produtoDomainDTO: ProdutoDomainDTO): ProdutoDomainDTO

    fun buscarProdutoPeloId(id: UUID): Optional<ProdutoDomainDTO>

    fun deletarProdutoPeloId(produtoId: UUID)

    fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<ProdutoDomainDTO>
}