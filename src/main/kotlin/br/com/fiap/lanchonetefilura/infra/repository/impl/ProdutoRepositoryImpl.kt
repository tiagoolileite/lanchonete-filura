package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.domain.dto.impl.ProdutoDTO
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

        return repository.findAllByCategoriaId(categoriaId)
    }

    override fun cadastrarProduto(produtoDTO: ProdutoDTO): ProdutoDTO {

        LoggerHelper.logger.info(
            "Produto ID: ${produtoDTO.id} Nome: ${produtoDTO.nome} \nCategoria ID: ${produtoDTO.categoria?.id} Descricao: ${produtoDTO.categoria?.descricao}"
        )

        return repository.save(produtoDTO)
    }

    override fun buscarProdutoPeloId(id: UUID): Optional<ProdutoDTO> {

        return repository.findById(id)
    }

    override fun atualizarProduto(produtoDTO: ProdutoDTO): ProdutoDTO {

        return repository.save(produtoDTO)
    }

    override fun deletarProdutoPeloId(id: UUID) {

        return repository.deleteById(id)
    }

    override fun listarProdutosPorListaDeIds(produtosId: List<UUID>?): MutableList<ProdutoDTO> {
        return produtosId?.let { repository.findAllById(it) } ?:
        throw Error("Produtos não localizados ou invalidos")
    }
}