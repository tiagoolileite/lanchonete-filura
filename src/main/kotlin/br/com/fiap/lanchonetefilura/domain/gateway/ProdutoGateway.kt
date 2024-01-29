package br.com.fiap.lanchonetefilura.domain.gateway

import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import java.util.*

interface ProdutoGateway {
    fun listarProdutos(): List<ProdutoDTO>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDTO>

    fun cadastrarProduto(
        categoria: CategoriaDTO?,
        descricao: String?,
        nome: String?,
        preco: Double?
    ): ProdutoDTO

    fun buscarProdutoPeloId(id: UUID): Optional<ProdutoDTO>

    fun atualizarProduto(produtoDTO: ProdutoDTO): ProdutoDTO

}
