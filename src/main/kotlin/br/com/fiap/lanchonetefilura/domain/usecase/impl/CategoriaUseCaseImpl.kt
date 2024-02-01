package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.domain.exceptions.DomainExceptionHelper
import br.com.fiap.lanchonetefilura.domain.gateway.CategoriaGateway
import br.com.fiap.lanchonetefilura.domain.usecase.CategoriaUseCase
import br.com.fiap.lanchonetefilura.infra.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoriaUseCaseImpl(
    val adapter: CategoriaAdapter,
    val gateway: CategoriaGateway
) : CategoriaUseCase {
    override fun cadastrarCategoria(descricao: String?): CategoriaDomainDTO {

        val categoria = Categoria(descricao)

        val categoriaDTO: CategoriaDomainDTO = adapter.adaptarCategoriaParaCategoriaDto(categoria)

        return gateway.cadastrarCategoria(categoriaDTO)
    }

    override fun listarCategorias(): List<CategoriaDomainDTO> {
        return gateway.listarCategorias()
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID): CategoriaDTOImpl? {

        val categoriaDTO: Optional<CategoriaDomainDTO> = gateway.buscarCategoriaPeloId(categoriaId)

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