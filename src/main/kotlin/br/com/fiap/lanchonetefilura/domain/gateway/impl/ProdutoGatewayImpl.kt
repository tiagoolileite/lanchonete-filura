package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDTO
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
        produtoDTO: ProdutoDTO
    ): ProdutoDTO {
        return repository.cadastrarProduto(
            produtoDTO
        )
    }

    override fun buscarProdutoPeloId(id: UUID): Optional<ProdutoDTO> {
        return repository.buscarProdutoPeloId(id)
    }

    override fun atualizarProduto(produtoDTO: ProdutoDTO): ProdutoDTO {
        return repository.atualizarProduto(produtoDTO)
    }

    override fun deletarProdutoPeloId(produtoId: UUID) {
        repository.deletarProdutoPeloId(produtoId)
    }

    override fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<ProdutoDTO> {
        return  repository.listarProdutosPorListaDeIds(produtosId)
    }
}