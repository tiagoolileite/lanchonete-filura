package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import br.com.fiap.lanchonetefilura.domain.controller.PedidoController
import br.com.fiap.lanchonetefilura.domain.usecase.PedidoUseCase
import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import org.springframework.stereotype.Component

@Component
class PedidoControllerImpl(
    val useCase: PedidoUseCase
) : PedidoController {

    override fun listarPedidos(): List<PedidoResponse> {

        val pedidosDTO: List<PedidoDTO> = useCase.listarPedidos()

        val pedidosResponse: ArrayList<PedidoResponse> = arrayListOf()
        val produtosResponse: ArrayList<ProdutoResponse> = arrayListOf()

        pedidosDTO.forEach {

            it.produtos.forEach { produto ->
                produtosResponse.add(
                    ProdutoResponse(
                    id = produto.id,
                    nome = produto.nome,
                    descricao = produto.descricao,
                    preco = produto.preco,
                    categoria = CategoriaResponse(
                        produto.categoria?.id,
                        produto.categoria?.descricao)
                )
                )
            }

            pedidosResponse.add(PedidoResponse(
                id = it.id,
                cliente = ClienteResponse(
                    id = it.cliente?.id,
                    cpf = it.cliente?.cpf,
                    nome = it.cliente?.nome,
                    email = it.cliente?.email
                ),
                senha = it.senha,
                etapa = it.etapa,
                produtos = produtosResponse.toList(),
                preco = it.preco,
                pago = it.pago
            ))
        }

        return pedidosResponse.toList()
    }
}