package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.domain.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoriaAdapterImpl : CategoriaAdapter {

    override fun adaptarCategoriaParaCategoriaDto(categoria: Categoria): CategoriaDomainDTOImpl {
        return CategoriaDomainDTOImpl(descricao = categoria.descricao)
    }

    override fun adaptarCategoriaDtoParaDomainDto(categoriaDTO: CategoriaDTO): CategoriaDomainDTO {
        return CategoriaDomainDTOImpl(
            id = categoriaDTO.id,
            descricao = categoriaDTO.descricao
        )
    }

    override fun adaptarCategoriasDtoParaDomainDto(categoriasDTO: List<CategoriaDTO>): List<CategoriaDomainDTO> {
        return categoriasDTO.map { categoriaDTO ->
            object : CategoriaDomainDTO {
                override var id: UUID
                    get() = categoriaDTO.id
                    set(value) { categoriaDTO.id = value }
                override val descricao: String?
                    get() = categoriaDTO.descricao
            }
        }
    }
}