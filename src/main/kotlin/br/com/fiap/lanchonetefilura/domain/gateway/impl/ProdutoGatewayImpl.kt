package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.gateway.ProdutoGateway
import br.com.fiap.lanchonetefilura.infra.dto.ProdutoDTO
import br.com.fiap.lanchonetefilura.infra.repository.ProdutoRepository
import org.springframework.stereotype.Component

@Component
class ProdutoGatewayImpl(val repository: ProdutoRepository) : ProdutoGateway {

    override fun listarProdutos(): List<ProdutoDTO> {
        return repository.listarProdutos()
    }
}