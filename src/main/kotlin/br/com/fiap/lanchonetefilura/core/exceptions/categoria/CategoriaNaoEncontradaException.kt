package br.com.fiap.lanchonetefilura.core.exceptions.categoria

import jakarta.persistence.EntityNotFoundException

class CategoriaNaoEncontradaException : EntityNotFoundException() {
    override val message: String
        get() = "Categoria não foi localizada!"
}
