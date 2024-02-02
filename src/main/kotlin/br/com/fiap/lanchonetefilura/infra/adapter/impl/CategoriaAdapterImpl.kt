package br.com.fiap.lanchonetefilura.infra.adapter.impl

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.infra.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import org.springframework.stereotype.Component

@Component
class CategoriaAdapterImpl : CategoriaAdapter {
    override fun adaptarCategoriaParaCategoriaDto(categoria : Categoria) : CategoriaDTO {
        TODO("Not yet implemented")
    }

    override fun adaptarCategoriaDtoParaCategoria(categoriaDTO : CategoriaDTO) : Categoria {
        TODO("Not yet implemented")
    }

    override fun adaptarCategoriasDtoParaCategorias(categoriasDTO : List<CategoriaDTO>) : List<Categoria> {
        TODO("Not yet implemented")
    }
}