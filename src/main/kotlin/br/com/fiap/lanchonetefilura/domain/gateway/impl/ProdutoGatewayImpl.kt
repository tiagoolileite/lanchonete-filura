package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.domain.dto.impl.ProdutoDTO
import br.com.fiap.lanchonetefilura.domain.gateway.ProdutoGateway
import br.com.fiap.lanchonetefilura.infra.repository.ProdutoRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoGatewayImpl(val repository: ProdutoRepository) : ProdutoGateway {

    override fun listarProdutos(): List<ProdutoDTO> {
        return repository.listarProdutos()
    }

    override fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDTO> {
        return repository.listarProdutosPorCategoria(categoriaId)
    }

    override fun cadastrarProduto(
        categoria: CategoriaDTOImpl,
        descricao: String?,
        nome: String?,
        preco: Double?
    ): ProdutoDTO {
        return repository.cadastrarProduto(
            ProdutoDTO(
            nome = nome,
            descricao = descricao,
            preco = preco,
            categoria = categoria
        )
        )
    }

    override fun buscarProdutoPeloId(id: UUID): Optional<ProdutoDTO> {
        return repository.buscarProdutoPeloId(id)
    }

    override fun atualizarProduto(produtoDTO: ProdutoDTO): ProdutoDTO {
        return repository.atualizarProduto(produtoDTO)
    }

    override fun deletarProdutoPeloId(id: UUID) {
        repository.deletarProdutoPeloId(id)
    }

    override fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<ProdutoDTO> {
        return  repository.listarProdutosPorListaDeIds(produtosId)
    }
}