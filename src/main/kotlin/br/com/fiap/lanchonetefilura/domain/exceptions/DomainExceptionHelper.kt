package br.com.fiap.lanchonetefilura.domain.exceptions

object DomainExceptionHelper {
    const val ERROR_DESCRICAO_CATEGORIA_VAZIA = "Descrição não pode estar vazia"
    const val ERROR_DESCRICAO_CATEGORIA_INVALIDA = "Descrição inválida"
    const val ERROR_CATEGORIA_NAO_LOCALIZADA = "Categoria informada não foi localizada"

    const val ERROR_PRODUTO_NAO_LOCALIZADO = "Produto Não Localizado"
    const val ERROR_PRODUTO_NAO_FOI_POSSIVEL_LOCALIZAR = "Não foi possivel localizar o produto"
}