package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.domain.gateway.ProdutoGateway
import br.com.fiap.lanchonetefilura.persistence.repository.ProdutoRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoGatewayImpl(
    val repository: ProdutoRepository
) : ProdutoGateway {

    override fun listarProdutos(): List<Produto> {

        return repository.listarProdutos()
    }

    override fun listarProdutosPorCategoria(categoriaId: UUID): List<Produto> {

        return repository.listarProdutosPorCategoria(categoriaId)
    }

    override fun cadastrarProduto(
        produto: Produto
    ): Produto {

        return repository.cadastrarOuAtualizarProduto(produto)
    }

    override fun buscarProdutoPeloId(id: UUID): Optional<Produto> {

        return repository.buscarProdutoPeloId(id)
    }

    override fun atualizarProduto(produto: Produto): Produto {

        return repository.cadastrarOuAtualizarProduto(produto)
    }

    override fun deletarProdutoPeloId(produtoId: UUID) {
        repository.deletarProdutoPeloId(produtoId = produtoId)
    }

    override fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<Produto> {

        return repository.listarProdutosPorListaDeIds(produtosId).toMutableList()
    }
}