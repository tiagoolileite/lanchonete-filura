package br.com.fiap.lanchonetefilura.domain.exceptions.categoria

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import jakarta.persistence.EntityExistsException

class CategoriaJaExisteException(categoria: Categoria? = null) : EntityExistsException() {
    override val message: String
        get() = "Essa Categoria Já Existe!"

    val entity: Categoria? = categoria
}
