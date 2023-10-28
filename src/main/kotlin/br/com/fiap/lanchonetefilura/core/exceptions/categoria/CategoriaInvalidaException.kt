package br.com.fiap.lanchonetefilura.core.exceptions.categoria

class CategoriaInvalidaException : Exception() {
    override val message: String
        get() = "Essa Categoria Já Existe!"
}
