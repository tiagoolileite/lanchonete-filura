package br.com.fiap.lanchonetefilura.infra.adapter.impl

import br.com.fiap.lanchonetefilura.infra.adapter.CategoriaInfraAdapter
import br.com.fiap.lanchonetefilura.infra.dto.impl.CategoriaDTOImpl
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoriaInfraAdapterImpl : CategoriaInfraAdapter {
    override fun initCategoriaDTO(id: UUID?, descricao: String?): CategoriaDTOImpl {
        return id?.let { CategoriaDTOImpl(id = it, descricao = descricao) } ?: also {
            LoggerHelper.logger.error(
                ("${LoggerHelper.LOG_TAG_APP}${LoggerHelper.LOG_TAG_ERROR}: " +
                    "Falha ao converter CategoriaDTO em CategoriaDomainDTO")
            )
        }.run { throw Exception("Falha ao iniciar CategoriaDTOImpl") }
    }
}