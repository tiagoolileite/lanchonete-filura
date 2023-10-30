package br.com.fiap.lanchonetefilura.core.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "pedido")
@JsonIgnoreProperties
data class PedidoModel (

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pedido_id")
    val id: UUID = UUID.randomUUID(),

    @Column(name = "senha", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val senha: Int = 1, //Código da ordem do pedido, será controlado por SEQUENCE no BD

    @Column(name = "etapa", nullable = false)
    val etapa: String = "Pendente pagamento",

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    val cliente: ClienteModel? = null,

    @ManyToMany
    @JoinTable(
        name = "pedidos_produtos",
        joinColumns = arrayOf(JoinColumn(name = "pedido_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "produto_id"))
    )
    val produtos: List<ProdutoModel> = arrayListOf(),

    @Column(name = "pago", nullable = false)
    var pago: Boolean = false
)