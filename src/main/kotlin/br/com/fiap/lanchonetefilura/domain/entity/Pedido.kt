package br.com.fiap.lanchonetefilura.domain.entity

import jakarta.persistence.Id
import java.util.UUID

data class Pedido (

    val id : UUID,

    var senha: Int = 0,

    var etapa: String,

    val cliente: Cliente? = null,

    val produtos: List<Produto> = arrayListOf(),

    var preco: Double = 0.0,

    var pago: Boolean = false
) {
    init {
        etapa = "em preparação"
    }
    companion object {
        val etapasValidas: ArrayList<String> = arrayListOf(
            "recebido", "em preparação", "pronto", "finalizado", "pendente pagamento"
        )
    }
}