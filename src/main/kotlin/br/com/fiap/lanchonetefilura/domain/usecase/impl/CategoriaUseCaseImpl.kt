package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.domain.exceptions.DomainExceptionHelper
import br.com.fiap.lanchonetefilura.domain.gateway.CategoriaGateway
import br.com.fiap.lanchonetefilura.domain.usecase.CategoriaUseCase
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoriaUseCaseImpl(
    val adapter: CategoriaAdapter,
    val gateway: CategoriaGateway
) : CategoriaUseCase {
    override fun cadastrarCategoria(descricao: String?): CategoriaDTO {

        val categoria = Categoria(descricao)

        val categoriaDTO: CategoriaDTOImpl = adapter.adaptarCategoriaParaCategoriaDto(categoria)

        return gateway.cadastrarCategoria(categoriaDTO)
    }

    override fun listarCategorias(): List<CategoriaDTO> {
        return gateway.listarCategorias()
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID): CategoriaDTOImpl? {

        val categoriaDTO: Optional<CategoriaDTO> = gateway.buscarCategoriaPeloId(categoriaId)

        var categoriaDTOImpl: CategoriaDTOImpl? = null

        if (categoriaDTO.isPresent) {
            categoriaDTO.get().let { categoria ->
                categoriaDTOImpl = CategoriaDTOImpl(
                    id = categoria.id,
                    descricao = categoria.descricao
                )
            }
        }

        return categoriaDTOImpl ?: also {
            LoggerHelper.logger.error(
                "${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: ${DomainExceptionHelper.ERROR_DESCRICAO_CATEGORIA_VAZIA}"
            )
        }.run {
            throw Exception(DomainExceptionHelper.ERROR_CATEGORIA_NAO_LOCALIZADA)
        }
    }
}