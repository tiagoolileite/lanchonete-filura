package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.gateway.ProdutoGateway
import br.com.fiap.lanchonetefilura.domain.usecase.ProdutoUseCase
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import org.springframework.stereotype.Component

@Component
class ProdutoUseCaseImpl(val gateway: ProdutoGateway) : ProdutoUseCase {
    override fun listarProdutos(): List<ProdutoDTO> {
        return gateway.listarProdutos()
    }
}