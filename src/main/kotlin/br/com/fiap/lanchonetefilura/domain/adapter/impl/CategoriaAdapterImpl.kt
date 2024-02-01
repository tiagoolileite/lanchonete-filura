package br.com.fiap.lanchonetefilura.domain.adapter.impl

import br.com.fiap.lanchonetefilura.domain.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDomainDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import org.springframework.stereotype.Component

@Component
class CategoriaAdapterImpl : CategoriaAdapter {

    override fun adaptarCategoriaParaCategoriaDto(categoria: Categoria): CategoriaDomainDTOImpl {
        return CategoriaDomainDTOImpl(descricao = categoria.descricao)
    }
}