package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.gateway.ProdutoGateway
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
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
        categoria: CategoriaDTO?,
        descricao: String?,
        nome: String?,
        preco: Double?
    ): ProdutoDTO {
        return repository.cadastrarProduto(ProdutoDTO(
            nome = nome,
            descricao = descricao,
            preco = preco,
            categoria = categoria
        ))
    }
}