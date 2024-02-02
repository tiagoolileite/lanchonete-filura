package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.domain.exceptions.categoria.CategoriaNaoEncontradaException
import br.com.fiap.lanchonetefilura.domain.exceptions.produto.ProdutoNaoEncontradoException
import br.com.fiap.lanchonetefilura.domain.gateway.ProdutoGateway
import br.com.fiap.lanchonetefilura.domain.usecase.CategoriaUseCase
import br.com.fiap.lanchonetefilura.domain.usecase.ProdutoUseCase
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoUseCaseImpl(
    val gateway: ProdutoGateway,
    val categoriaUseCase: CategoriaUseCase
) : ProdutoUseCase {
    override fun listarProdutos(): List<Produto> {

        return gateway.listarProdutos()
    }

    override fun listarProdutosPorCategoria(categoriaId: UUID): List<Produto> {

        return gateway.listarProdutosPorCategoria(categoriaId = categoriaId)
    }

    override fun cadastrarProduto(
        categoriaId: UUID,
        descricao: String,
        nome: String,
        preco: Double
    ): Produto {

        val categoria: Categoria = categoriaUseCase.buscarCategoriaPeloId(categoriaId = categoriaId)
            ?: throw CategoriaNaoEncontradaException()

        val produto = Produto(
            nome = nome,
            descricao = descricao,
            preco = preco,
            categoria = categoria,
        )

        return gateway.cadastrarProduto(produto = produto)
    }

    override fun buscarProdutoPeloId(id: UUID): Produto {

        val produto: Optional<Produto> = gateway.buscarProdutoPeloId(id = id)

        if (produto.isEmpty) {
            throw ProdutoNaoEncontradoException()
        }

        return produto.get()
    }

    override fun atualizarProduto(
        produtoId: UUID,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): Produto {

        val categoria: Categoria? = categoriaId?.let { categoriaUseCase.buscarCategoriaPeloId(it) }

        val produtoEncontrado = this.buscarProdutoPeloId(produtoId)

        nome?.let {
            produtoEncontrado.nome = it
        }

        categoria?.let {
            produtoEncontrado.categoria = it
        }

        preco?.let {
            produtoEncontrado.preco = it
        }

        descricao?.let {
            produtoEncontrado.descricao = it
        }

        return gateway.atualizarProduto(produtoEncontrado)
    }

    override fun deletarProdutoPeloId(produtoId: UUID) {

        gateway.deletarProdutoPeloId(produtoId = produtoId)
    }

    override fun listarProdutosPorListaDeIds(produtosId : List<UUID>) : List<Produto> {
        val produtos: MutableList<Produto> = gateway.listarProdutosPorListaDeIds(produtosId = produtosId)

        return produtos.toList()
    }
}