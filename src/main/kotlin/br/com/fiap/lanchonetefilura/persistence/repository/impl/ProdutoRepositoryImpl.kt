package br.com.fiap.lanchonetefilura.persistence.repository.impl

import br.com.fiap.lanchonetefilura.domain.entity.Produto
import br.com.fiap.lanchonetefilura.persistence.adapter.ProdutoAdapter
import br.com.fiap.lanchonetefilura.persistence.dto.ProdutoDTO
import br.com.fiap.lanchonetefilura.persistence.repository.ProdutoRepository
import br.com.fiap.lanchonetefilura.persistence.repository.jpa.ProdutoJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProdutoRepositoryImpl(
    private val repository: ProdutoJpaRepository,
    private val adapter: ProdutoAdapter
) : ProdutoRepository {
    override fun listarProdutos(): List<Produto> {

        val produtosDTO: List<ProdutoDTO> = repository.findAll()

        return adapter.adaptarProdutosDTOParaProdutos(produtosDTO)
    }

    override fun listarProdutosPorCategoria(categoriaId: UUID): List<Produto> {

        val produtosDTO: List<ProdutoDTO> = repository.findAllByCategoriaId(categoriaId).toList()

        return adapter.adaptarProdutosDTOParaProdutos(produtosDTO)
    }

    override fun cadastrarOuAtualizarProduto(produto: Produto): Produto {

        val produtoDTO: ProdutoDTO = adapter.adaptarProdutoParaProdutoDTO(produto)

        return adapter.adaptarProdutoDTOParaProduto(repository.save(produtoDTO))
    }

    override fun buscarProdutoPeloId(id: UUID): Optional<Produto> {

        val produtoDTO: Optional<ProdutoDTO> = repository.findById(id)

        return Optional.of(adapter.adaptarProdutoDTOParaProduto(produtoDTO.get()))
    }

    override fun deletarProdutoPeloId(produtoId: UUID) {

        return repository.deleteById(produtoId)
    }

    override fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<Produto> {

        val produtos: MutableList<ProdutoDTO>? = produtosId?.let { repository.findAllById(it) }

        if (produtos != null) {
            return adapter.adaptarProdutosDTOParaProdutos(produtos.toList()).toMutableList()
        } else {
            throw Exception("Falha ao configurar lista de Produtos")
        }
    }
}