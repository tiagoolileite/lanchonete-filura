package br.com.fiap.lanchonetefilura.domain.exceptions.categoria

import jakarta.persistence.EntityExistsException

class CategoriaJaExisteException(categoria: CategoriaModel? = null) : EntityExistsException() {
    override val message: String
        get() = "Essa Categoria Já Existe!"

    val entity: CategoriaModel? = categoria
}
