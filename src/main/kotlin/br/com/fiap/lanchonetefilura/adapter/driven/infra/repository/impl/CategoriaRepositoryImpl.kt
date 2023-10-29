package br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.impl

import br.com.fiap.lanchonetefilura.adapter.driven.infra.extensions.converterCategoriaRequestToCategoriaDTO
import br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.CategoriaJpaRepository
import br.com.fiap.lanchonetefilura.core.applications.repository.CategoriaRepository
import br.com.fiap.lanchonetefilura.core.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import br.com.fiap.lanchonetefilura.core.domain.request.CategoriaRequest
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class CategoriaRepositoryImpl(private val repository: CategoriaJpaRepository) : CategoriaRepository {
    override fun getCategorias(): List<CategoriaDTO>? {

        return repository.findAll()
    }

    override fun getCategoriaById(id: UUID): CategoriaDTO? {

        var categoria: CategoriaDTO? = null

        try {
           categoria = repository.findCategoriaById(id = id)
        } catch (ex: Exception) {
            logger.info("Categoria não foi localizada")
        }

        return categoria
    }

    override fun getCategoriaByDescricao(descricao: String): CategoriaDTO? {

        var categoria: CategoriaDTO? = null

        try {
            categoria = repository.findCategoriaByDescricao(descricao = descricao)
        } catch (ex: Exception) {
            logger.info("Categoria não foi localizada")
        }

        return categoria
    }

    override fun saveCategoria(categoriaRequest: CategoriaRequest): CategoriaModel? {

        val categoria = categoriaRequest.converterCategoriaRequestToCategoriaDTO()

        return repository.save(categoria)
    }
}