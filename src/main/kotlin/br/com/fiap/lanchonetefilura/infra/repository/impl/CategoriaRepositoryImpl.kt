package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.infra.repository.CategoriaRepository
import br.com.fiap.lanchonetefilura.infra.repository.jpa.CategoriaJpaRepository
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CategoriaRepositoryImpl(private val repository: CategoriaJpaRepository) : CategoriaRepository {


    /*override fun getCategorias(): List<CategoriaModel>? {

        return repository.findAll()
    }

    override fun getCategoriaById(id: UUID): CategoriaModel? {

        var categoria: CategoriaModel? = null

        try {
           categoria = repository.findCategoriaById(id = id)
        } catch (ex: Exception) {
            logger.info("Categoria não foi localizada")
        }

        return categoria
    }

    override fun getCategoriaByDescricao(descricao: String): CategoriaModel? {

        var categoria: CategoriaModel? = null

        try {
            categoria = repository.findCategoriaByDescricao(descricao = descricao)
        } catch (ex: Exception) {
            logger.info("Categoria não foi localizada")
        }

        return categoria
    }*/
    override fun cadastrarCategoria(descricao: String): CategoriaDTO {

        val categoriaDTO = CategoriaDTO(descricao = descricao)

        logger.info("Descrição: ${categoriaDTO.descricao} \n ID: ${categoriaDTO.id}")

        return repository.save(categoriaDTO)
    }

    override fun listarCategorias(): List<CategoriaDTO> {
        return repository.findAll()
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID): CategoriaDTO {

        logger.info("Procurando pela categoria de id: ${categoriaId}")
        return repository.findCategoriaById(categoriaId)
    }
}