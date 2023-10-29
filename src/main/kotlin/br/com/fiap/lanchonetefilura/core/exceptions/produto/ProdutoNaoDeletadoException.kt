package br.com.fiap.lanchonetefilura.core.exceptions.produto

class ProdutoNaoDeletadoException : Exception() {
    override val message: String
        get() = "Não foi possível deletar o produto"
}