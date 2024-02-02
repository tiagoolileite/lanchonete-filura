package br.com.fiap.lanchonetefilura.domain.exceptions.produto

class ProdutoInvalidaException : Exception() {
    override val message: String
        get() = "Produto Inválido"
}
