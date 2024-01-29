package br.com.fiap.lanchonetefilura.domain.entity

class Categoria {
    val descricao: CategoriaDescricaoEnum? = null

    fun validaDescricao(descicao: String) {

        val descricaoValida = CategoriaDescricaoEnum.values().any {
            it.descricaoCategoria.lowercase() == descicao.lowercase()
        }

        if (!descricaoValida) {
            throw Error("Descrição da categoria inválida")
        }
    }
}