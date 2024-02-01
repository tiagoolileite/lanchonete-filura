package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDomainDTOImpl
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
    override fun cadastrarCategoria(descricao: String?): CategoriaDomainDTO {

        val categoria = Categoria(descricao = descricao)

        val categoriaDTO: CategoriaDomainDTO = adapter.adaptarCategoriaParaCategoriaDto(categoria = categoria)

        return gateway.cadastrarCategoria(categoriaDomainDTO = categoriaDTO)
    }

    override fun listarCategorias(): List<CategoriaDomainDTO> {
        return gateway.listarCategorias()
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID): CategoriaDomainDTOImpl? {

        val categoriaDTO: Optional<CategoriaDomainDTO> = gateway.buscarCategoriaPeloId(categoriaId = categoriaId)

        var categoriaDTOImpl: CategoriaDomainDTOImpl? = null

        if (categoriaDTO.isPresent) {
            categoriaDTO.get().let { categoria ->
                categoriaDTOImpl = CategoriaDomainDTOImpl(
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