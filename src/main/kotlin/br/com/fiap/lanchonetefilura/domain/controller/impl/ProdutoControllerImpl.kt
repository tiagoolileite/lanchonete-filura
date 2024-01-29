package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.controller.ProdutoController
import br.com.fiap.lanchonetefilura.domain.usecase.ProdutoUseCase
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import org.springframework.stereotype.Component

@Component
class ProdutoControllerImpl(
    val useCase: ProdutoUseCase
) : ProdutoController {

    override fun listarProdutos(): List<ProdutoResponse> {

        val produtoDTO: List<ProdutoDTO> = useCase.listarProdutos()

        val produtosResponse: ArrayList<ProdutoResponse> = arrayListOf()

        produtoDTO.forEach {
            produtosResponse.add(ProdutoResponse(
                id = it.id,
                nome = it.nome,
                descricao = it.descricao,
                preco = it.preco,
                categoria = CategoriaResponse(
                    id = it.categoria?.id,
                    descricao = it.categoria?.descricao
                )
            )
            )
        }

        return produtosResponse.toList()
    }
}