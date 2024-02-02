package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.adapter.ProdutoAdapter
import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.gateway.ProdutoGateway
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import br.com.fiap.lanchonetefilura.infra.repository.ProdutoRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoGatewayImpl(
    val repository: ProdutoRepository,
    val adapter: ProdutoAdapter
) : ProdutoGateway {

    override fun listarProdutos(): List<ProdutoDomainDTO> {

        val produtosDTO: List<ProdutoDTO> = repository.listarProdutos()

        return adapter.adaptarProdutosDtoParaDomainDto(produtosDTO)
    }

    override fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDomainDTO> {

        val produtosDTO: List<ProdutoDTO> = repository.listarProdutosPorCategoria(categoriaId)

        return adapter.adaptarProdutosDtoParaDomainDto(produtosDTO)
    }

    override fun cadastrarProduto(
        produtoDomainDTO: ProdutoDomainDTO
    ): ProdutoDomainDTO {

        val produtoDTO: ProdutoDTO = repository.cadastrarOuAtualizarProduto(produtoDomainDTO)

        return adapter.adaptarProdutoDtoParaDomainDto(produtoDTO)
    }

    override fun buscarProdutoPeloId(id: UUID): Optional<ProdutoDomainDTO> {

        val produtoDTO: Optional<ProdutoDTO> = repository.buscarProdutoPeloId(id)

        return adapter.adaptarProdutoDtoParaOptionalDomainDto(produtoDTO)
    }

    override fun atualizarProduto(produtoDomainDTO: ProdutoDomainDTO): ProdutoDomainDTO {

        val produtoDTO: ProdutoDTO = repository.cadastrarOuAtualizarProduto(produtoDomainDTO)

        return adapter.adaptarProdutoDtoParaDomainDto(produtoDTO)
    }

    override fun deletarProdutoPeloId(produtoId: UUID) {
        repository.deletarProdutoPeloId(produtoId)
    }

    override fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<ProdutoDomainDTO> {

        val produtosDTO: MutableList<ProdutoDTO> = repository.listarProdutosPorListaDeIds(produtosId)

        return  adapter.adaptarProdutosMutableDtoParaMutableDomainDto(produtosDTO)
    }
}