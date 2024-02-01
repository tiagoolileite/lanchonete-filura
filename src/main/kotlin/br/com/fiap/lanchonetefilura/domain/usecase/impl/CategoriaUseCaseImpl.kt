package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.adapter.CategoriaAdapter
import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.domain.entity.Categoria
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

        LoggerHelper.logger.info("1: " + categoria.descricao)

        val categoriaDTO: CategoriaDTOImpl = adapter.adaptarCategoriaParaCategoriaDto(categoria)

        LoggerHelper.logger.info("2: " + categoriaDTO.descricao)

        return gateway.cadastrarCategoria(categoriaDTO)
    }

    override fun listarCategorias(): List<CategoriaDTO> {
        return gateway.listarCategorias()
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID): CategoriaDTOImpl {
        return gateway.buscarCategoriaPeloId(categoriaId)
    }
}