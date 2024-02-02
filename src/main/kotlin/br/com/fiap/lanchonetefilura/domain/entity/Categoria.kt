package br.com.fiap.lanchonetefilura.domain.entity

import br.com.fiap.lanchonetefilura.domain.exceptions.DomainExceptionHelper.ERROR_DESCRICAO_CATEGORIA_VAZIA
import br.com.fiap.lanchonetefilura.domain.exceptions.categoria.CategoriaInvalidaException
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.LOG_TAG_APP
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.LOG_TAG_ERROR
import java.util.*

data class Categoria (
    val id: UUID = UUID.randomUUID(),
    val descricao: String
) {
    init {
        check(this.descricao.isNotEmpty()) {
            LoggerHelper.logger.error(
                "${LOG_TAG_APP}${LOG_TAG_ERROR}: $ERROR_DESCRICAO_CATEGORIA_VAZIA"
            )
        }
        validaDescricao()
    }

    private fun validaDescricao() {

        val descricaoValida = descricoesValidas.contains(this.descricao.lowercase())

        if (!descricaoValida) {
            throw CategoriaInvalidaException()
        }
    }

    companion object {
        val descricoesValidas: ArrayList<String> = arrayListOf(
            "acompanhamento", "bebida", "lanche"
        )
    }
}