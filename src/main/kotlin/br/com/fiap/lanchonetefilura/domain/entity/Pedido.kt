package br.com.fiap.lanchonetefilura.domain.entity

data class Pedido (
    var senha: Int? = null,

    val etapa: String = "pendente pagamento",

    val cliente: Cliente? = null,

    val produtos: List<Produto> = arrayListOf(),

    var preco: Double = 0.0,

    var pago: Boolean = false
) {
    companion object {
        val etapasValidas: ArrayList<String> = arrayListOf(
            "recebido", "em preparação", "pronto", "finalizado", "pendente pagamento"
        )
    }
}