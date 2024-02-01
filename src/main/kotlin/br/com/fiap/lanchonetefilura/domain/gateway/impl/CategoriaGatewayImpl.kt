package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import br.com.fiap.lanchonetefilura.domain.gateway.CategoriaGateway
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.infra.repository.CategoriaRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoriaGatewayImpl(
    val repository: CategoriaRepository,
    val adapter: CategoriaAdapter
) : CategoriaGateway {
    override fun cadastrarCategoria(categoriaDomainDTO: CategoriaDomainDTO): CategoriaDomainDTO {

        val categoriaDTO: CategoriaDTO =
            repository.cadastrarCategoria(categoriaDomainDTO = categoriaDomainDTO)

        return adapter.adaptarCategoriaDtoParaDomainDto(categoriaDTO)
    }

    override fun listarCategorias(): List<CategoriaDomainDTO> {

        val categoriasDTO: List<CategoriaDTO> = repository.listarCategorias()

        return adapter.adaptarCategoriasDtoParaDomainDto(categoriasDTO)
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID): Optional<CategoriaDomainDTO> {

        val categoriaDTO: Optional<CategoriaDTO> = repository.buscarCategoriaPeloId(categoriaId)

        return Optional.of(adapter.adaptarCategoriaDtoParaDomainDto(
            categoriaDTO = categoriaDTO.get()
        ))
    }
}