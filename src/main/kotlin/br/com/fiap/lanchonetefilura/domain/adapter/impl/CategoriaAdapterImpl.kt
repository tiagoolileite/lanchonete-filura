package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.api.model.categoria.CategoriaResponse
import br.com.fiap.lanchonetefilura.domain.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import org.springframework.stereotype.Component

@Component
class CategoriaAdapterImpl : CategoriaAdapter {
    override fun adaptarCategoria(categoriaDTO: CategoriaDTO?): CategoriaResponse {
        return CategoriaResponse(
            id = categoriaDTO?.id,
            descricao = categoriaDTO?.descricao
        )
    }

    override fun adaptarListaDeCategoria(categoriasDTO: List<CategoriaDTO?>): List<CategoriaResponse> {
        val categoriasResponse: ArrayList<CategoriaResponse> = arrayListOf()

        categoriasDTO.forEach {
            categoriasResponse.add(CategoriaResponse(
                id = it?.id,
                descricao = it?.descricao))
        }

        return categoriasResponse.toList()
    }
}