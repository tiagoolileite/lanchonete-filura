package br.com.fiap.lanchonetefilura.domain.entity

import br.com.fiap.lanchonetefilura.domain.exceptions.DomainExceptionHelper.ERROR_DESCRICAO_CATEGORIA_INVALIDA
import br.com.fiap.lanchonetefilura.domain.exceptions.DomainExceptionHelper.ERROR_DESCRICAO_CATEGORIA_VAZIA
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.LOG_TAG_APP
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.LOG_TAG_ERROR

data class Categoria (
    val descricao: String? = null
) {
    init {
        check(!this.descricao.isNullOrEmpty()) {
            LoggerHelper.logger.error(
                "${LOG_TAG_APP}${LOG_TAG_ERROR}: ${ERROR_DESCRICAO_CATEGORIA_VAZIA}"
            )
        }
        validaDescricao()
    }

    private fun validaDescricao() {

        val descricaoValida = descricoesValidas.contains(this.descricao?.lowercase())

        if (!descricaoValida) {
            throw Error(ERROR_DESCRICAO_CATEGORIA_INVALIDA)
        }
    }

    companion object {
        val descricoesValidas: ArrayList<String> = arrayListOf(
            "acompanhamento", "bebida", "lanche"
        )
    }
}