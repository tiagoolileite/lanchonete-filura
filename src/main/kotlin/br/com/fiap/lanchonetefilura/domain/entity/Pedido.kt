package br.com.fiap.lanchonetefilura.domain.entity

import java.util.*

data class Pedido(

    val id: UUID = UUID.randomUUID(),

    var senha : Int = 0,

    var etapa : String,

    val cliente : Cliente? = null,

    val produtos : List<Produto> = arrayListOf(),

    var preco : Double = 0.0,

    var pago : Boolean = false
) {
    init {
        etapa = "em preparação"
    }
    companion object {
        enum class EtapasValidas(val etapaDescricao: String) {
            PENDENTE_PAGAMENTO("pendente pagamento"),
            RECEBIDO("recebido"),
            EM_PREPARACAO("em preparação"),
            PRONTO("pronto"),
            FINALIZADO("finalizado")
        }
    }
}