package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import br.com.fiap.lanchonetefilura.domain.gateway.CategoriaGateway
import br.com.fiap.lanchonetefilura.infra.repository.CategoriaRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoriaGatewayImpl(val repository: CategoriaRepository) : CategoriaGateway {
    override fun cadastrarCategoria(categoriaDTO: CategoriaDomainDTO): CategoriaDomainDTO {
        return repository.cadastrarCategoria(categoriaDTO)
    }

    override fun listarCategorias(): List<CategoriaDomainDTO> {
        return repository.listarCategorias()
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID): Optional<CategoriaDomainDTO> {
        return repository.buscarCategoriaPeloId(categoriaId)
    }
}