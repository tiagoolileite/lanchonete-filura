package br.com.fiap.lanchonetefilura.domain.exceptions.categoria

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import jakarta.persistence.EntityExistsException

class CategoriaJaExisteException(categoria: CategoriaDomainDTO? = null) : EntityExistsException() {
    override val message: String
        get() = "Essa Categoria Já Existe!"

    val entity: CategoriaDomainDTO? = categoria
}
