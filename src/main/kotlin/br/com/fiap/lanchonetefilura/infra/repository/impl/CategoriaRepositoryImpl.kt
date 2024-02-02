package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.infra.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.infra.repository.CategoriaRepository
import br.com.fiap.lanchonetefilura.infra.repository.jpa.CategoriaJpaRepository
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CategoriaRepositoryImpl(
    private val repository: CategoriaJpaRepository,
    private val adapter: CategoriaAdapter
) : CategoriaRepository {

    override fun cadastrarCategoria(categoria: Categoria): Categoria {
        logger.info("${LoggerHelper.LOG_TAG_APP}: Cadastrando categoria na base: ${categoria.descricao}")

        val categoriaDTO: CategoriaDTO = adapter.adaptarCategoriaParaCategoriaDto(categoria)

        return adapter.adaptarCategoriaDtoParaCategoria(
            repository.save(categoriaDTO)
        )
    }

    override fun listarCategorias(): List<Categoria> {
        logger.info("${LoggerHelper.LOG_TAG_APP}: Listando categorias da base")

        val categoriasDTO: List<CategoriaDTO> = repository.findAll()

        return adapter.adaptarCategoriasDtoParaCategorias(categoriasDTO)
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID): Optional<Categoria> {
        logger.info("${LoggerHelper.LOG_TAG_APP}: Buscando pela categorias na base: $categoriaId")

        val categoriaDTO: Optional<CategoriaDTO> = repository.findById(categoriaId)

        return Optional.of(adapter.adaptarCategoriaDtoParaCategoria(categoriaDTO.get()))
    }
}