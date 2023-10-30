package br.com.fiap.lanchonetefilura.core.exceptions.pedido

import jakarta.persistence.EntityNotFoundException

class PedidoNaoEncontradoException : EntityNotFoundException() {
    override val message: String
        get() = "Pedido não foi localizado!"
}
