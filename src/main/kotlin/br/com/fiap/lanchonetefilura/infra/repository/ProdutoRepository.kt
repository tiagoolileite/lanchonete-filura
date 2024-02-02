package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.domain.entity.Produto
import java.util.*

interface ProdutoRepository {

    fun listarProdutos(): List<Produto>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<Produto>

    fun cadastrarOuAtualizarProduto(produto: Produto): Produto

    fun buscarProdutoPeloId(id: UUID): Optional<Produto>

    fun deletarProdutoPeloId(produtoId: UUID)

    fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<Produto>
}