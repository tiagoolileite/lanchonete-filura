package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import java.util.*

interface ProdutoRepository {

    fun listarProdutos(): List<ProdutoDTO>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDTO>

    fun cadastrarOuAtualizarProduto(produtoDomainDTO: ProdutoDomainDTO): ProdutoDTO

    fun buscarProdutoPeloId(id: UUID): Optional<ProdutoDTO>

    fun deletarProdutoPeloId(produtoId: UUID)

    fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<ProdutoDTO>
}