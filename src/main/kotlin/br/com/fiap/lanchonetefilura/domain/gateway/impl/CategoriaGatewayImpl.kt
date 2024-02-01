package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.domain.gateway.CategoriaGateway
import br.com.fiap.lanchonetefilura.infra.repository.CategoriaRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoriaGatewayImpl(val repository: CategoriaRepository) : CategoriaGateway {
    override fun cadastrarCategoria(categoriaDTO: CategoriaDTOImpl): CategoriaDTO {
        return repository.cadastrarCategoria(categoriaDTO)
    }

    override fun listarCategorias(): List<CategoriaDTO> {
        return repository.listarCategorias()
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID): CategoriaDTOImpl {
        return repository.buscarCategoriaPeloId(categoriaId)
    }
}