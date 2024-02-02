package br.com.fiap.lanchonetefilura.domain.entity

import java.util.*

data class Pedido(

    var id: UUID = UUID.randomUUID(),

    var senha : Int? = null,

    var etapa : String,

    val cliente : Cliente? = null,

    val produtos : List<Produto> = arrayListOf(),

    var preco : Double = 0.0,

    var pago : Boolean = false
) {
    init {
        etapa = EtapasValidas.PENDENTE_PAGAMENTO.etapaDescricao

        check(preco >= 0.0) {
            throw Exception("Preço não pode ser negativo")
        }

        check(produtos.isNotEmpty()) {
            throw Exception("Lista de produtos para um pedido não pode estar vazia")
        }
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