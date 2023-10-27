package br.com.fiap.lanchonetefilura.adapter.driver.api.exception.categoria

class CategoriaInvalidaException : Exception() {
    override val message: String
        get() = "Essa Categoria Já Existe!"
}
