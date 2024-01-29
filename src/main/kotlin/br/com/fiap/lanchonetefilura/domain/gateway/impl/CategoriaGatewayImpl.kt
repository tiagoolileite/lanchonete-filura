package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.gateway.CategoriaGateway
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.infra.repository.CategoriaRepository
import org.springframework.stereotype.Component

@Component
class CategoriaGatewayImpl(val repository: CategoriaRepository) : CategoriaGateway {
    override fun cadastrarCategoria(descricao: String): CategoriaDTO {
        return repository.cadastrarCategoria(descricao)
    }

    override fun listarCategorias(): List<CategoriaDTO> {
        return repository.listarCategorias()
    }
}