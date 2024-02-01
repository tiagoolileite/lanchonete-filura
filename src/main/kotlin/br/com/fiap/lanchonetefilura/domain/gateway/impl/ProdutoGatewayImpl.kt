package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.gateway.ProdutoGateway
import br.com.fiap.lanchonetefilura.infra.repository.ProdutoRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoGatewayImpl(val repository: ProdutoRepository) : ProdutoGateway {

    override fun listarProdutos(): List<ProdutoDomainDTO> {
        return repository.listarProdutos()
    }

    override fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDomainDTO> {
        return repository.listarProdutosPorCategoria(categoriaId)
    }

    override fun cadastrarProduto(
        produtoDTO: ProdutoDomainDTO
    ): ProdutoDomainDTO {
        return repository.cadastrarOuAtualizarProduto(produtoDTO)
    }

    override fun buscarProdutoPeloId(id: UUID): Optional<ProdutoDomainDTO> {
        return repository.buscarProdutoPeloId(id)
    }

    override fun atualizarProduto(produtoDTO: ProdutoDomainDTO): ProdutoDomainDTO {
        return repository.cadastrarOuAtualizarProduto(produtoDTO)
    }

    override fun deletarProdutoPeloId(produtoId: UUID) {
        repository.deletarProdutoPeloId(produtoId)
    }

    override fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<ProdutoDomainDTO> {
        return  repository.listarProdutosPorListaDeIds(produtosId)
    }
}