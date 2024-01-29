package br.com.fiap.lanchonetefilura.domain.exceptions.categoria

import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import jakarta.persistence.EntityExistsException

class CategoriaJaExisteException(categoria: CategoriaDTO? = null) : EntityExistsException() {
    override val message: String
        get() = "Essa Categoria Já Existe!"

    val entity: CategoriaDTO? = categoria
}
