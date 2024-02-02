package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.domain.entity.Produto
import java.util.*

interface ProdutoGateway {
    fun listarProdutos(): List<Produto>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<Produto>

    fun cadastrarProduto(
        produto: Produto
    ): Produto

    fun buscarProdutoPeloId(id: UUID): Optional<Produto>

    fun atualizarProduto(produto: Produto): Produto

    fun deletarProdutoPeloId(produtoId: UUID)

    fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<Produto>
}
