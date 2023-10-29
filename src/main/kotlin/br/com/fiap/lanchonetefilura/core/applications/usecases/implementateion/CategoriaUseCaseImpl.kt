package br.com.fiap.lanchonetefilura.core.applications.usecases.implementateion

import br.com.fiap.lanchonetefilura.core.applications.repository.CategoriaRepository
import br.com.fiap.lanchonetefilura.core.applications.usecases.CategoriaUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.request.CategoriaRequest
import br.com.fiap.lanchonetefilura.core.exceptions.categoria.CategoriaInvalidaException
import br.com.fiap.lanchonetefilura.core.exceptions.categoria.CategoriaJaExisteException
import br.com.fiap.lanchonetefilura.core.exceptions.categoria.CategoriaNaoEncontradaException
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import org.springframework.stereotype.Component
import java.util.UUID
import kotlin.collections.ArrayList

@Component
class CategoriaUseCaseImpl (
    private val categoriaRepository: CategoriaRepository
) : CategoriaUseCase {

    override fun getCategorias(): List<CategoriaModel>? {

        return categoriaRepository.getCategorias()
    }

    override fun getCategoriaById(id: UUID): CategoriaModel? {

        val categoria: CategoriaModel? = categoriaRepository.getCategoriaById(id = id)

        categoria?.let {} ?: throw CategoriaNaoEncontradaException()

        return categoria
    }

    override fun getCategoriaByDescricao(descricao: String): CategoriaModel? {

        val categoria: CategoriaModel? = categoriaRepository.getCategoriaByDescricao(descricao = descricao)

        categoria?.let {} ?: throw CategoriaNaoEncontradaException()

        return categoria
    }

    override fun saveCategoria(categoriaRequest: CategoriaRequest): CategoriaModel? {

        if (!categoriasPossiveis.contains(categoriaRequest.descricao?.lowercase())) {
            throw CategoriaInvalidaException()
        }

        val categoria: CategoriaModel? =
            categoriaRequest.descricao?.let { categoriaRepository.getCategoriaByDescricao(descricao = it) }

        categoria?.let {
            logger.error("Categoria já foi cadastrada anteriormente")
            throw CategoriaJaExisteException()
        }

        return categoriaRepository.saveCategoria(categoriaRequest)
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