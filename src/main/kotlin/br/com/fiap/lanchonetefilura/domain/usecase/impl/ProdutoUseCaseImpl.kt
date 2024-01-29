package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.gateway.ProdutoGateway
import br.com.fiap.lanchonetefilura.domain.usecase.ProdutoUseCase
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoUseCaseImpl(val gateway: ProdutoGateway) : ProdutoUseCase {
    override fun listarProdutos(): List<ProdutoDTO> {
        return gateway.listarProdutos()
    }

    override fun listarProdutosPorCategoria(categoriaId: UUID): List<ProdutoDTO> {
        return gateway.listarProdutosPorCategoria(categoriaId)
    }

    override fun cadastrarProduto(
        categoria: CategoriaDTO,
        descricao: String?,
        nome: String?,
        preco: Double?
    ): ProdutoDTO {
        return gateway.cadastrarProduto(
            categoria = categoria,
            descricao = descricao,
            nome = nome,
            preco = preco
        )
    }

    override fun buscarProdutoPeloId(id: UUID): ProdutoDTO? {

        val produto = gateway.buscarProdutoPeloId(id)

        if (produto.isEmpty) {
            throw Exception("Não foi localizado produto para atualização")
        }

        return produto.get()
    }

    override fun atualizarProduto(
        produtoDTO: ProdutoDTO,
        nome: String?,
        categoriaId: UUID?,
        preco: Double?,
        descricao: String?
    ): ProdutoDTO {
        produtoDTO.nome = nome
        categoriaId?.let { produtoDTO.categoria?.id = categoriaId }
        produtoDTO.preco = preco
        produtoDTO.descricao = descricao

        return gateway.atualizarProduto(produtoDTO)
    }

    override fun deletarProdutoPeloId(id: UUID) {
        gateway.deletarProdutoPeloId(id)
    }
}