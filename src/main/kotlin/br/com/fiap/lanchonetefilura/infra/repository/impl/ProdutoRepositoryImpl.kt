package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.infra.dto.impl.ProdutoDTOImpl
import br.com.fiap.lanchonetefilura.infra.repository.ProdutoRepository
import br.com.fiap.lanchonetefilura.infra.repository.jpa.ProdutoJpaRepository
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProdutoRepositoryImpl(private val repository: ProdutoJpaRepository) : ProdutoRepository {
    override fun listarProdutos(): List<ProdutoDTO> {
        return repository.findAll()
    }

    override fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDTO> {

        return repository.findAllByCategoriaId(categoriaId).toList()
    }

    override fun cadastrarOuAtualizarProduto(produtoDomainDTO: ProdutoDomainDTO): ProdutoDTO {

        val produtoDTO = ProdutoDTOImpl(
            id = produtoDomainDTO.id,
            nome = produtoDomainDTO.nome,
            descricao = produtoDomainDTO.descricao,
            preco = produtoDomainDTO.preco,
            categoria = produtoDomainDTO.categoria?.id?.let {
                CategoriaDTOImpl(
                    id = it,
                    descricao = produtoDomainDTO.categoria?.descricao
                )
            }
        )

        return repository.save(produtoDTO)
    }

    override fun buscarProdutoPeloId(id: UUID): Optional<ProdutoDTO> {

        val produtoDTO: Optional<ProdutoDTOImpl> = repository.findById(id)

        return Optional.of(produtoDTO.get())
    }

    override fun deletarProdutoPeloId(produtoId: UUID) {

        return repository.deleteById(produtoId)
    }

    override fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<ProdutoDTO> {

        val produtosDTO: MutableList<ProdutoDTOImpl>? = produtosId?.let { repository.findAllById(it) }

        val produtosDomainDTO: MutableList<ProdutoDTO> = produtosDTO?.map { produtoDTO ->
            object : ProdutoDTO {
                override var id: UUID?
                    get() = produtoDTO.id
                    set(value) { produtoDTO.id = value }

                override var nome: String?
                    get() = produtoDTO.nome
                    set(value) { produtoDTO.nome = value }

                override var descricao: String?
                    get() = produtoDTO.descricao
                    set(value) { produtoDTO.descricao = value }

                override var preco: Double?
                    get() = produtoDTO.preco
                    set(value) { produtoDTO.preco = value }

                override var categoria: CategoriaDTOImpl?
                    get() = produtoDTO.categoria
                    set(value) { produtoDTO.categoria = value }
                override val pedidos: List<PedidoDTO>?
                    get() = null
            }
        }?.toMutableList() ?: also {
            LoggerHelper.logger.error("${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: " +
                    "Falha ao converter lista de produtos ou produtos não localizados")
        }.run { throw Exception("Falha ao converter lista de produtos retornada pelo BD ou Produtos n") }

        return produtosDomainDTO
    }
}