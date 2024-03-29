package br.com.fiap.lanchonetefilura.persistence.adapter.impl

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.persistence.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.persistence.dto.CategoriaDTO
import org.springframework.stereotype.Component

@Component
class CategoriaAdapterImpl : CategoriaAdapter {
    override fun adaptarCategoriaParaCategoriaDto(categoria : Categoria) : CategoriaDTO {
        return CategoriaDTO(
            id = categoria.id,
            descricao = categoria.descricao
        )
    }

    override fun adaptarCategoriaDtoParaCategoria(categoriaDTO : CategoriaDTO) : Categoria {
        return categoriaDTO.descricao?.let {
            Categoria(
                id = categoriaDTO.id,
                descricao = it
            )
        } ?: throw Exception("Falha ao tentar adaptar lista de categorias")
    }

    override fun adaptarCategoriasDtoParaCategorias(categoriasDTO : List<CategoriaDTO>) : List<Categoria> {
        return categoriasDTO.map { categoriaDTO ->
            adaptarCategoriaDtoParaCategoria(categoriaDTO = categoriaDTO)
        }
    }
}