package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDTO
import java.util.*

interface ProdutoGateway {
    fun listarProdutos(): List<ProdutoDTO>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDTO>

    fun cadastrarProduto(
        produtoDTO: ProdutoDTO
    ): ProdutoDTO

    fun buscarProdutoPeloId(id: UUID): Optional<ProdutoDTO>

    fun atualizarProduto(produtoDTO: ProdutoDTO): ProdutoDTO

    fun deletarProdutoPeloId(produtoId: UUID)

    fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<ProdutoDTO>
}
