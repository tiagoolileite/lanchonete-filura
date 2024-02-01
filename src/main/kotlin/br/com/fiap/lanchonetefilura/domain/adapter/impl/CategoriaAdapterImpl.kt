package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import org.springframework.stereotype.Component

@Component
class CategoriaAdapterImpl : CategoriaAdapter {
    override fun adaptarCategoria(categoriaDTO: CategoriaDomainDTO?): CategoriaResponse {
        return CategoriaResponse(
            id = categoriaDTO?.id,
            descricao = categoriaDTO?.descricao
        )
    }

    override fun adaptarListaDeCategoria(categoriasDTO: List<CategoriaDomainDTO?>): List<CategoriaResponse> {
        val categoriasResponse: ArrayList<CategoriaResponse> = arrayListOf()

        categoriasDTO.forEach {
            categoriasResponse.add(CategoriaResponse(
                id = it?.id,
                descricao = it?.descricao))
        }

        return categoriasResponse.toList()
    }

    override fun adaptarCategoriaParaCategoriaDto(categoria: Categoria): CategoriaDomainDTOImpl {
        return CategoriaDomainDTOImpl(descricao = categoria.descricao)
    }
}