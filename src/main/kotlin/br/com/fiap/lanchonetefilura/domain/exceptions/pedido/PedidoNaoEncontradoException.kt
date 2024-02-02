package br.com.fiap.lanchonetefilura.domain.exceptions.pedido

import jakarta.persistence.EntityNotFoundException

class PedidoNaoEncontradoException : EntityNotFoundException() {
    override val message: String
        get() = "Pedido não foi localizado!"
}
