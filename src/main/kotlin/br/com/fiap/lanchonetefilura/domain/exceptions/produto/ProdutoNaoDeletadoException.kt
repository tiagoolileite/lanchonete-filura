package br.com.fiap.lanchonetefilura.domain.exceptions.produto

class ProdutoNaoDeletadoException : Exception() {
    override val message: String
        get() = "Não foi possível deletar o produto"
}