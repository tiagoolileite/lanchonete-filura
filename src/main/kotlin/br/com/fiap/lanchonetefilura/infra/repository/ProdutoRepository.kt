package br.com.fiap.lanchonetefilura.infra.repository

import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import java.util.*

interface ProdutoRepository {

    fun listarProdutos(): List<ProdutoDTO>

    fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDTO>

    fun cadastrarProduto(produtoDTO: ProdutoDTO): ProdutoDTO

    fun buscarProdutoPeloId(id: UUID): Optional<ProdutoDTO>

    fun atualizarProduto(produtoDTO: ProdutoDTO): ProdutoDTO

    fun deletarProdutoPeloId(id: UUID)
}