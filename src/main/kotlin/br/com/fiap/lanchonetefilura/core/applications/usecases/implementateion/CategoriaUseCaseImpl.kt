package br.com.fiap.lanchonetefilura.core.applications.usecases.implementateion

import br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.CategoriaRepository
import br.com.fiap.lanchonetefilura.adapter.driver.api.extensions.converterCategoriaRequestToCategoriaModel
import br.com.fiap.lanchonetefilura.adapter.driver.api.extensions.converterFindAllCategoriasToArrayList
import br.com.fiap.lanchonetefilura.core.exceptions.categoria.CategoriaInvalidaException
import br.com.fiap.lanchonetefilura.adapter.driver.api.request.CategoriaRequest
import br.com.fiap.lanchonetefilura.core.applications.usecases.CategoriaUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import org.springframework.stereotype.Component
import java.util.UUID
import kotlin.collections.ArrayList

@Component
class CategoriaUseCaseImpl (
    private val categoriaRepository: CategoriaRepository
) : CategoriaUseCase {
    override fun findById(id: UUID): CategoriaModel? {

        return categoriaRepository.findById(id).get()
    }

    override fun findAll(): ArrayList<CategoriaModel>? {
        return converterFindAllCategoriasToArrayList(categoriaRepository.findAll())
    }

    override fun save(categoria: CategoriaRequest): CategoriaModel? {
        if (!categoriasPossiveis.contains(categoria.descricao?.lowercase())) {
            throw CategoriaInvalidaException()
        }

        return categoriaRepository.save(converterCategoriaRequestToCategoriaModel(categoria))
    }

    private val categoriasPossiveis: ArrayList<String> = arrayListOf(
        CategoriaDescricaoEnum.Lanche.toString().lowercase(),
        CategoriaDescricaoEnum.Acompanhamento.toString().lowercase(),
        CategoriaDescricaoEnum.Bebida.toString().lowercase()
    )

    enum class CategoriaDescricaoEnum {
        Lanche, Acompanhamento, Bebida
    }
}