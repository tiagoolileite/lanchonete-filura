package br.com.fiap.lanchonetefilura.adapter.driver.api.exception.categoria

import br.com.fiap.lanchonetefilura.core.domain.model.CategoriaModel
import jakarta.persistence.EntityExistsException

class CategoriaJaExisteException(categoria: CategoriaModel? = null) : EntityExistsException() {
    override val message: String
        get() = "Essa Categoria Já Existe!"

    val entity: CategoriaModel? = categoria
}
