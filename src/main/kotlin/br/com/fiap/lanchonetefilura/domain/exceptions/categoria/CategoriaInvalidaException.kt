package br.com.fiap.lanchonetefilura.domain.exceptions.categoria

class CategoriaInvalidaException : Exception() {
    override val message: String
        get() = "Categoria Inválida"
}
