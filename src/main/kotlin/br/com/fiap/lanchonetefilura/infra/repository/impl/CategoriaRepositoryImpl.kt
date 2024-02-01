package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.infra.repository.CategoriaRepository
import br.com.fiap.lanchonetefilura.infra.repository.jpa.CategoriaJpaRepository
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CategoriaRepositoryImpl(private val repository: CategoriaJpaRepository) : CategoriaRepository {

    override fun cadastrarCategoria(categoriaDomainDTO: CategoriaDomainDTO): CategoriaDomainDTO {
        logger.info("${LoggerHelper.LOG_TAG_APP}: Cadastrando categoria na base: ${categoriaDomainDTO.descricao}")

        val categoriaDTO = CategoriaDTOImpl(
            id = categoriaDomainDTO.id,
            descricao = categoriaDomainDTO.descricao
        )

        return repository.save(categoriaDTO)
    }

    override fun listarCategorias(): List<CategoriaDomainDTO> {
        logger.info("${LoggerHelper.LOG_TAG_APP}: Listando categorias da base")

        return repository.findAll()
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID): Optional<CategoriaDomainDTO> {
        logger.info("${LoggerHelper.LOG_TAG_APP}: Buscando pela categorias na base: $categoriaId")

        val categoriaDTO: Optional<CategoriaDTOImpl> = repository.findById(categoriaId)

        return Optional.of(categoriaDTO.get())
    }
}